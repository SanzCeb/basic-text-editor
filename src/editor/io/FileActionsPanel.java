package editor.io;

import editor.IconManager;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

public class FileActionsPanel extends Box {

    private JButton loadButton;
    private JButton saveButton;
    private JTextField searchField;
    private JButton previousMatchButton;
    private JButton startSearchButton;
    private JButton nextMatchButton;
    private JCheckBox useRegexCheckbox;


    public FileActionsPanel() {
        super(0);
        var margin = new EmptyBorder(5,5,5,5);
        setBorder(new CompoundBorder(getBorder(), margin));

            loadButton = new JButton(IconManager.openFileIcon());
            loadButton.setName("OpenButton");

            saveButton = new JButton(IconManager.saveFileIcon());
            saveButton.setName("SaveButton");

            searchField = new JTextField();
            searchField.setName("SearchField");


            startSearchButton = new JButton(IconManager.searchIcon());
            startSearchButton.setName("StartSearchButton");

            previousMatchButton = new JButton(IconManager.arrowBackIcon());
            previousMatchButton.setName("PreviousMatchButton");

            nextMatchButton = new JButton(IconManager.arrowForwardIcon());
            nextMatchButton.setName("NextMatchButton");

            useRegexCheckbox = new JCheckBox("Use Regex");
            useRegexCheckbox.setName("UseRegExCheckbox");


            add(Box.createHorizontalStrut(5));
            add(loadButton);
            add(Box.createHorizontalStrut(5));
            add(saveButton);
            add(Box.createHorizontalStrut(5));
            add(searchField);
            add(Box.createHorizontalStrut(5));
            add(startSearchButton);
            add(Box.createHorizontalStrut(5));
            add(previousMatchButton);
            add(Box.createHorizontalStrut(5));
            add(nextMatchButton);
            add(Box.createHorizontalStrut(5));
            add(useRegexCheckbox);
    }

    public void addSaveButtonListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }
    
    public void addLoadButtonListener(ActionListener listener) {
        loadButton.addActionListener(listener);
    }

    public void addStartSearchButtonListener(ActionListener listener) {
        startSearchButton.addActionListener(listener);
    }

    public void addPreviousMatchButtonListener(ActionListener listener) {
        previousMatchButton.addActionListener(listener);
    }

    public void addNextMatchButtonListener(ActionListener listener) {
        nextMatchButton.addActionListener(listener);
    }

    public boolean getRegex() {
        return useRegexCheckbox.isSelected();
    }

    public void setRegex(boolean b) {
        useRegexCheckbox.setSelected(true);
    }

    public String getSearchField() {
        return searchField.getText();
    }

}
