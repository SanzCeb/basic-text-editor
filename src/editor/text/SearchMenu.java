package editor.text;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SearchMenu extends JMenu {

    private final JMenuItem startSearchMenuItem;
    private final JMenuItem previousMatchMenuItem;
    private final JMenuItem nextMatchMenuItem;
    private final JMenuItem useRegExpMenuItem;

    public SearchMenu() {
        super("Search");
        setName("MenuSearch");

        startSearchMenuItem = new JMenuItem("Start search");
        previousMatchMenuItem = new JMenuItem("Previous search");
        nextMatchMenuItem = new JMenuItem("Next match");
        useRegExpMenuItem = new JMenuItem("Use regular expressions");

        startSearchMenuItem.setName("MenuStartSearch");
        previousMatchMenuItem.setName("MenuPreviousMatch");
        nextMatchMenuItem.setName("MenuNextMatch");
        useRegExpMenuItem.setName("MenuUseRegExp");

        add(startSearchMenuItem);
        add(previousMatchMenuItem);
        add(nextMatchMenuItem);
        add(useRegExpMenuItem);
    }

    public void addStartSearchMenuItemListener(ActionListener listener) {
        startSearchMenuItem.addActionListener(listener);
    }

    public void addPreviousMatchMenuItemListener(ActionListener listener) {
        previousMatchMenuItem.addActionListener(listener);
    }

    public void addNextMatchMenuItemListener(ActionListener listener) {
        nextMatchMenuItem.addActionListener(listener);
    }

    public void addUseRegExpMenuItemListener(ActionListener listener) {
        useRegExpMenuItem.addActionListener(listener);
    }

}
