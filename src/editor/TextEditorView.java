package editor;

import java.awt.event.ActionListener;

public interface TextEditorView {

    void setLoadActionListener(ActionListener listener);

    void setSaveActionListener(ActionListener listener);

    void setText(String text);

    String getText();

    String getFileName();

    void closeView();

    void setCloseActionListener(ActionListener listener);
}
