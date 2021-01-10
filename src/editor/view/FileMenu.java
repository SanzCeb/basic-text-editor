package editor.view;


import javax.swing.*;
import java.awt.event.ActionListener;

public class FileMenu extends JMenu {
    private final JMenuItem loadMenuItem;
    private final JMenuItem saveMenuItem;
    private final JMenuItem exitMenuItem;

    public FileMenu() {
        super("File");
        setName("MenuFile");

        loadMenuItem = new JMenuItem("Open");
        loadMenuItem.setName("MenuOpen");
        saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setName("MenuSave");
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setName("MenuExit");

        add(loadMenuItem);
        add(saveMenuItem);
        addSeparator();
        add(exitMenuItem);

    }

    public void addSaveMenuItemListener(ActionListener listener) {
        saveMenuItem.addActionListener(listener);
    }

    public void addExitMenuItemListener(ActionListener listener) {
        exitMenuItem.addActionListener(listener);
    }

    public void addLoadMenuItemListener(ActionListener listener) {
        loadMenuItem.addActionListener(listener);
    }
}
