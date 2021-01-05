package editor;

import javax.swing.*;

public class TextEditor extends JFrame {
    private JTextArea textArea;
    public TextEditor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setTitle("Text Editor");
        setLayout(null);
        textArea = new TextArea();
        add(textArea);
        textArea.setLocation(25, 25);
        setVisible(true);

    }
}
