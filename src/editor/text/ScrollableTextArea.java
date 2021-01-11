package editor.text;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ScrollableTextArea extends JScrollPane {
    private JTextArea textArea;
    private volatile ListIterator<MatchResult> resultsListIterator;
    private List<MatchResult> searchResultsList;

    public ScrollableTextArea () {
        super(new JTextArea());
        this.textArea = (JTextArea) this.getViewport().getView();
        setSize(new Dimension(200, 200));
        textArea.setName("TextArea");

        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        var margin = new EmptyBorder(10,10,10,10);
        setBorder(new CompoundBorder(getBorder(), margin));
        setName("ScrollPane");
    }

    public void setText(String text) {
        this.textArea.setText(text);
    }

    public String getText() {
        return this.textArea.getText();
    }

    public void search (String searchInput, boolean regex) {
        new RegexSearch(searchInput, regex).execute();
    }

    public void previousMatch() {

        if (!resultsListIterator.hasPrevious()){
            resetResultsListIterator(searchResultsList.size());
        }

        if (resultsListIterator.hasPrevious()) {
            var result = resultsListIterator.previous();
            if (result.start() == textArea.getSelectionStart()) {
                if (!resultsListIterator.hasPrevious()) {
                    resetResultsListIterator(searchResultsList.size());
                }
                result = resultsListIterator.previous();

            }
            focusText(result.start(), result.end());
        }

    }

    public void nextMatch() {
        if (!resultsListIterator.hasNext()) {
            resetResultsListIterator(0);
        }

        if (resultsListIterator.hasNext()) {
            var result = resultsListIterator.next();
            if (result.start() == textArea.getSelectionStart()) {
                if (!resultsListIterator.hasNext()) {
                    resetResultsListIterator(0);
                }
                result = resultsListIterator.next();
            }
            focusText(result.start(), result.end());
        }
    }

    private void focusText(int beginIndex, int endIndex) {
        textArea.setCaretPosition(endIndex);
        textArea.select(beginIndex, endIndex);
        textArea.grabFocus();
    }

    private void resetResultsListIterator (int index) {
        resultsListIterator = searchResultsList.listIterator(index);
    }

    private class RegexSearch extends SwingWorker<List<MatchResult>, Object>{
        private Pattern searchInput;

        public RegexSearch(String searchInput, boolean regex) {
            this.searchInput = Pattern.compile(regex ? searchInput : Pattern.quote(searchInput));

        }

        @Override
        protected List<MatchResult> doInBackground() {
            var matcher = searchInput.matcher(textArea.getText());
            return matcher.results().collect(Collectors.toList());
        }

        @Override
        protected void done() {
            try {
                searchResultsList = get();
                resultsListIterator = searchResultsList.listIterator();
                var result = resultsListIterator.next();
                focusText(result.start(), result.end());
            } catch (Exception ignore){

            }
        }
    }
}
