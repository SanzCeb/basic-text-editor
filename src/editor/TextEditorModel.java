package editor;

import java.nio.file.Path;

public interface TextEditorModel {
    void saveTextFile(Path path, String text);

    String loadTextFile(Path path);

}
