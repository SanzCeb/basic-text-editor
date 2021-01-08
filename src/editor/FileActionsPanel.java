package editor;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

public class FileActionsPanel extends Box {
    private final JButton loadButton;
    private final JButton saveButton;
    private final JTextField filenameField;

    public FileActionsPanel() {
        super(0);

        var margin = new EmptyBorder(10,10,10,10);
        setBorder(new CompoundBorder(getBorder(), margin));

        filenameField = new JTextField();
        filenameField.setName("FilenameField");
        loadButton = new JButton("Load");
        loadButton.setName("LoadButton");
        saveButton = new JButton("Save");
        saveButton.setName("SaveButton");
        add(createHorizontalGlue());
        add(filenameField);
        add(Box.createHorizontalStrut(5));
        add(saveButton);
        add(Box.createHorizontalStrut(5));
        add(loadButton);
    }
    
    public String getFileName() {
        return filenameField.getText();
    }
    
    public void addSaveButtonListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }
    
    public void addLoadButtonListener(ActionListener listener) {
        loadButton.addActionListener(listener);
    }
}
