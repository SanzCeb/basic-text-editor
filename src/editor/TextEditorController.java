package editor;

import editor.view.TextEditorView;

import java.nio.file.Path;
import java.util.Optional;

public class TextEditorController {
    private TextEditorModel model;
    private Optional<Path> optionalPath = Optional.empty();

    public void setView (TextEditorView view) {

        view.setLoadActionListener(e -> {
            optionalPath = view.getOpenPath();
            optionalPath.ifPresent(path -> {
                view.setText(model.loadTextFile(path));
            });
        });

        view.setSaveActionListener(actionEvent -> {
            optionalPath = view.getSavePath();
            optionalPath.ifPresent(path -> {
                var text = view.getText();
                model.saveTextFile(path, text);
            });
        });



    }

    public void setModel (TextEditorModel model) {
        this.model = model;
    }
}
