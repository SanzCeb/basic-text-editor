package editor.view;

import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IconManager {
    private static final String ICONS_DIR = String.join(File.separator, "Text Editor","task","icons");
    private static final String USER_DIR = String.join(File.separator, System.getProperty("user.dir"), ICONS_DIR);

    public static Icon openFileIcon() {
       return openIcon("open_file.png");
    }

    public static Icon saveFileIcon() {
       return openIcon("save_file.png");
    }

    public static Icon searchIcon() {
       return openIcon("search.png");
    }

    public static Icon arrowBackIcon() {
       return openIcon("arrow_back.png");
    }

    public static Icon arrowForwardIcon() {
       return openIcon("arrow_forward.png");
    }

    private static Path getPath (String fileName) {
        return Paths.get(String.join(File.separator, USER_DIR, fileName));
    }

    private static Icon openIcon(String iconName) {
        try {
            return new ImageIcon(Files.readAllBytes(getPath(iconName)));
        } catch (Exception ignored) {
            return null;
        }
    }
}
