package editor;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.*;

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
            var iconFile = Files.readAllBytes(getPath(iconName));
            var image = new ImageIcon(iconFile).getImage();
            var icon = image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
            return new ImageIcon(icon);
        } catch (Exception ignored) {
            return null;
        }
    }
}
