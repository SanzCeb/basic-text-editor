package editor;

import java.io.IOException;

public class TextEditorController {
    private TextEditorModel model;

    public void setView (TextEditorView view) {
        view.setLoadButtonListener( e -> {
            var fileName = view.getFileName();
            try {
                var text = model.loadTextFile(fileName);
                view.setText(text);
            } catch (IOException ioException) {
                view.setText("");
            }
        });

        view.setSaveButtonListener(actionEvent -> {
            var fileName = view.getFileName();
            var text = view.getText();
            model.saveTextFile(fileName, text);
        });

    }

    public void setModel (TextEditorModel model) {
        this.model = model;
    }
}
