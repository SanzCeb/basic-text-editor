package editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TextEditor extends JFrame implements TextEditorView {
    private static final TextEditorController CONTROLLER = new TextEditorController();
    private final TextEditorMenu actionMenu;
    private ScrollableTextArea scrollableTextArea;
    private FileActionsPanel fileActionsPanel;

    public TextEditor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setTitle("Text Editor");
        setLayout(new BorderLayout());
        setResizable(false);

        scrollableTextArea = new ScrollableTextArea(new TextArea());
        fileActionsPanel = new FileActionsPanel();
        add(fileActionsPanel, BorderLayout.NORTH);
        add(scrollableTextArea, BorderLayout.CENTER);
        scrollableTextArea.setLocation(25, 25);

        actionMenu = new TextEditorMenu();
        setJMenuBar(new JMenuBar());
        getJMenuBar().add(actionMenu);

        CONTROLLER.setView(this);
        CONTROLLER.setModel(new UserDirectory());

        setVisible(true);
    }

    @Override
    public void setLoadActionListener(ActionListener listener) {

        fileActionsPanel.addLoadButtonListener(listener);
        actionMenu.addLoadMenuItemListener(listener);
    }

    @Override
    public void setSaveActionListener(ActionListener listener) {

        fileActionsPanel.addSaveButtonListener(listener);
        actionMenu.addSaveMenuItemListener(listener);
    }

    @Override
    public void setText(String text) {
        scrollableTextArea.setText(text);
    }

    @Override
    public String getText() {
        return scrollableTextArea.getText();
    }

    @Override
    public String getFileName() {
        return fileActionsPanel.getFileName();
    }

    @Override
    public void setCloseActionListener(ActionListener listener) {
        actionMenu.addExitMenuItemListener(listener);
    }

    @Override
    public void closeView() {
        dispose();
        System.exit(0);
    }
}


