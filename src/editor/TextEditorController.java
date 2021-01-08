package editor;

import java.io.IOException;

public class TextEditorController {
    private TextEditorModel model;

    public void setView (TextEditorView view) {
        view.setLoadActionListener(e -> {
            var fileName = view.getFileName();
            try {
                var text = model.loadTextFile(fileName);
                view.setText(text);
            } catch (IOException ioException) {
                view.setText("");
            }
        });

        view.setSaveActionListener(actionEvent -> {
            var fileName = view.getFileName();
            var text = view.getText();
            model.saveTextFile(fileName, text);
        });

        view.setCloseActionListener(actionEvent -> view.closeView());

    }

    public void setModel (TextEditorModel model) {
        this.model = model;
    }
}
