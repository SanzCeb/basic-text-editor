package editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TextEditor extends JFrame implements TextEditorView {
    private static final TextEditorController CONTROLLER = new TextEditorController();
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

        CONTROLLER.setView(this);
        CONTROLLER.setModel(new UserDirectory());

        setVisible(true);
    }

    @Override
    public void setLoadButtonListener(ActionListener listener) {
        fileActionsPanel.addLoadButtonListener(listener);
    }

    @Override
    public void setSaveButtonListener(ActionListener listener) {
        fileActionsPanel.addSaveButtonListener(listener);
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
}


