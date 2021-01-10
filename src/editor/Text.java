package editor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Text implements TextEditorModel {

    @Override
    public void saveTextFile(Path path, String text) {
        try {
            Files.deleteIfExists(path);
            Files.writeString(path, text, StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String loadTextFile(Path path) {
        try {
            return Files.readString(path);
        } catch (IOException e) {
            return "";
        }
    }
}
