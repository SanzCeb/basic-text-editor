package editor;

import editor.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.Optional;

public class TextEditor extends JFrame implements TextEditorView {
    private static final TextEditorController CONTROLLER = new TextEditorController();
    private final FileMenu fileMenu = new FileMenu();
    private final SearchMenu searchMenu = new SearchMenu();
    private ScrollableTextArea scrollableTextArea;
    private FileActionsPanel fileActionsPanel;
    private TextEditorFileChooser fileChooser = new TextEditorFileChooser();

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

        CONTROLLER.setView(this);
        CONTROLLER.setModel(new Text());

        fileMenu.addExitMenuItemListener(e -> {
            dispose();
            System.exit(0);
        });

        setStartSearchListener();
        setPreviousMatchListener();
        setNextMatchListener();
        setUseRegExListener();
        setVisible(true);
    }

    @Override
    public void setLoadActionListener(ActionListener listener) {

        fileActionsPanel.addLoadButtonListener(listener);
        fileMenu.addLoadMenuItemListener(listener);
    }

    @Override
    public void setSaveActionListener(ActionListener listener) {

        fileActionsPanel.addSaveButtonListener(listener);
        fileMenu.addSaveMenuItemListener(listener);
    }

    public void setText(String text) {
        scrollableTextArea.setText(text);
    }

    @Override
    public String getText() {
        return scrollableTextArea.getText();
    }

    @Override
    public Optional<Path> getOpenPath() {
        return fileChooser.openFile();
    }

    @Override
    public Optional<Path> getSavePath() {
        return fileChooser.saveFile();
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

}


