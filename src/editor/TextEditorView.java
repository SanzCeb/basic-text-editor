package editor;

import java.awt.event.ActionListener;

public interface TextEditorView {

    void setLoadButtonListener(ActionListener listener);

    void setSaveButtonListener(ActionListener listener);

    void setText(String text);

    String getText();

    String getFileName();
}
