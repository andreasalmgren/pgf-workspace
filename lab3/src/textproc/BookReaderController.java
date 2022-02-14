package textproc;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BookReaderController {
    public BookReaderController(GeneralWordCounter counter) {
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
    }

    private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // pane är en behållarkomponent till vilken de
        // övriga komponenterna (listvy, knappar etc.) ska läggas till.
        Container pane = frame.getContentPane();

        // Creating scrollPane
        SortedListModel<Map.Entry<String, Integer>> listmodel = new SortedListModel(counter.getWordList());
        JList<Map.Entry<String, Integer>> listvy = new JList<>(listmodel);
        pane.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(listvy);

        // Creating buttons
        JRadioButton Alphabetic = new JRadioButton("Alphabetic");
        JRadioButton Frequency = new JRadioButton("Frequency");
        JButton Search = new JButton("Search");
        // Creating a panel to add buttons
        JPanel p = new JPanel();
        // Adding buttons to panel
        p.add(Alphabetic);
        p.add(Frequency);
        p.add(Search);

        // create JTextField with default text and columns
        JTextField field = new JTextField("", 1);

        // Adding stuff to frame
        pane.add(scrollPane, BorderLayout.NORTH);
        pane.add(field, BorderLayout.CENTER);
        pane.add(p, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);

        Alphabetic.addActionListener(e -> {
            listmodel.sort((p1, p2) -> p2.getKey().compareTo(p1.getKey()));
        });
        Frequency.addActionListener(e -> {
            listmodel.sort((p1, p2) -> p2.getValue() - p1.getValue());
        });
        Search.addActionListener(e -> {
            Boolean exist = false;
            String searchText = "";
            searchText = field.getText().trim().toLowerCase();
            for (int i = 0; i < listmodel.getSize(); i++) {
                if (listmodel.getElementAt(i).getKey().equals(searchText)) {
                    exist = true;
                    listvy.ensureIndexIsVisible(i);
                    listvy.setSelectedIndex(i);
                    break;
                } else {
                    exist = false;
                }
            }
            if (!exist && searchText.length() != 0) {
                JOptionPane.showMessageDialog(pane, searchText + " does not exist in this list.");
            } else if (!exist) {
                JOptionPane.showMessageDialog(pane, "Field is empty");
            }
        });
    }
}