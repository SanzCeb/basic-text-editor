package editor;

import java.io.IOException;

public interface TextEditorModel {
    void saveTextFile(String filename, String text);
    String loadTextFile(String Filename) throws IOException;
}
