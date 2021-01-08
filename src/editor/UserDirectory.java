package editor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UserDirectory implements TextEditorModel {
    @Override
    public void saveTextFile(String filename, String text) {
        try {
            var filePath = Paths.get(filename);
            Files.deleteIfExists(filePath);
            Files.writeString(filePath, text, StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String loadTextFile(String filename) throws IOException {
        return Files.readString(Path.of(filename));
    }
}
