package editor.view;

import javax.swing.*;
import java.io.File;
import java.nio.file.Path;
import java.util.Optional;

public class TextEditorFileChooser extends JFileChooser {
    public TextEditorFileChooser() {
        setName("FileChooser");
    }

    public Optional<Path> openFile(){
        int returnValue = showOpenDialog(null);
        var file = returnValue == JFileChooser.APPROVE_OPTION ? getSelectedFile() : null;
        return Optional.ofNullable(file).map(File::toPath);
    }

    public Optional<Path> saveFile() {
        int returnValue = showSaveDialog(null);
        var file = returnValue == JFileChooser.APPROVE_OPTION ? getSelectedFile() : null;
        return Optional.ofNullable(file).map(File::toPath);
    }

}
