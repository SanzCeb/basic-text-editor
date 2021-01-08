package editor;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class ScrollableTextArea extends JScrollPane {
    private JTextArea textArea;
    public ScrollableTextArea (JTextArea textArea) {
        super(textArea);
        this.textArea = textArea;
        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        var margin = new EmptyBorder(10,10,10,10);
        setBorder(new CompoundBorder(getBorder(), margin));
        setName("ScrollPane");
    }


    public void setText(String text) {
        this.textArea.setText(text);
    }

    public String getText() {
        return this.textArea.getText();
    }
}
