package editor;

import editor.io.*;
import editor.text.*;
import javax.swing.*;
import java.awt.*;
import java.nio.file.*;
import java.awt.event.ActionListener;

public class TextEditor extends JFrame {
    private final FileMenu fileMenu = new FileMenu();
    private final SearchMenu searchMenu = new SearchMenu();
    private ScrollableTextArea scrollableTextArea;
    private FileActionsPanel fileActionsPanel;
    private FileChooser fileChooser = new FileChooser();

    public TextEditor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setTitle("Text Editor");
        setLayout(new BorderLayout());
        setResizable(false);

        scrollableTextArea = new ScrollableTextArea();
        fileActionsPanel = new FileActionsPanel();
        add(fileActionsPanel, BorderLayout.NORTH);
        add(fileChooser, BorderLayout.CENTER);
        add(scrollableTextArea, BorderLayout.CENTER);
        scrollableTextArea.setLocation(25, 25);

        setJMenuBar(new JMenuBar());
        getJMenuBar().add(fileMenu);
        getJMenuBar().add(searchMenu);

        setExitActionListener();
        setLoadActionListener();
        setSaveActionListener();
        setStartSearchListener();
        setPreviousMatchListener();
        setNextMatchListener();
        setUseRegExListener();
        setVisible(true);
    }

    private void setExitActionListener() {
        fileMenu.addExitMenuItemListener(e -> {
            dispose();
            System.exit(0);
        });
    }

    private void setLoadActionListener() {
        ActionListener listener = e -> fileChooser
                .openFile()
                .map(FileLoader::new)
                .ifPresent(SwingWorker::execute);
        fileActionsPanel.addLoadButtonListener(listener);
        fileMenu.addLoadMenuItemListener(listener);
    }

    private void setSaveActionListener() {
        ActionListener listener = e ->
                fileChooser.saveFile()
                        .map(FileSaver::new)
                        .map(Thread::new)
                        .ifPresent(Thread::start);
        fileActionsPanel.addSaveButtonListener(listener);
        fileMenu.addSaveMenuItemListener(listener);
    }

    private void setStartSearchListener() {
        ActionListener listener = e -> {
            var searchField = fileActionsPanel.getSearchField();
            var regex = fileActionsPanel.getRegex();
            scrollableTextArea.search(searchField, regex);
        };
        fileActionsPanel.addStartSearchButtonListener(listener);
        searchMenu.addStartSearchMenuItemListener(listener);
    }

    private void setPreviousMatchListener() {
        ActionListener listener = e -> scrollableTextArea.previousMatch();
        fileActionsPanel.addPreviousMatchButtonListener(listener);
        searchMenu.addPreviousMatchMenuItemListener(listener);
    }


    private void setNextMatchListener() {
        ActionListener listener = e -> scrollableTextArea.nextMatch();
        fileActionsPanel.addNextMatchButtonListener(listener);
        searchMenu.addNextMatchMenuItemListener(listener);
    }

    private void setUseRegExListener() {
        ActionListener menuItemListener = e -> {
            fileActionsPanel.setRegex(true);
        };
        searchMenu.addUseRegExpMenuItemListener(menuItemListener);
    }

    private class FileLoader extends SwingWorker<String, Object> {
        private final Path path;
        FileLoader(Path path) {
            this.path = path;
        }
        @Override
        protected String doInBackground() {
            try {
                return Files.readString(path);
            } catch (Exception ignored) {
                return "";
            }
        }
        @Override
        protected void done() {
            try {
                scrollableTextArea.setText(get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class FileSaver implements Runnable {
        private final Path path;
        public FileSaver(Path path) {
            this.path = path;
        }
        @Override
        public void run() {
            try {
                var text = scrollableTextArea.getText();
                Files.deleteIfExists(path);
                Files.writeString(path, text, StandardOpenOption.CREATE_NEW);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


