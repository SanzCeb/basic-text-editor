package editor.view;

import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.Optional;

public interface TextEditorView {

    void setLoadActionListener(ActionListener listener);

    void setSaveActionListener(ActionListener listener);

    void setText(String text);

    String getText();

    Optional<Path> getOpenPath();

    Optional<Path> getSavePath();
}
