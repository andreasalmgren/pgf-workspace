package textproc;
import javax.swing.*;
import java.util.Map;
import java.awt.BorderLayout;
import java.awt.Container;

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

        // Creating a new buttons
        JButton Alphabetic = new JButton("Alphabetic");
        JButton Frequency = new JButton("Frequency");

        // Creating a panel to add buttons
        JPanel p = new JPanel();

        // Adding buttons and textfield to panel
        // using add() method
        p.add(Alphabetic);
        p.add(Frequency);

        SortedListModel<Map.Entry<String, Integer>> listmodel = new SortedListModel(counter.getWordList());
        JList listvy = new JList(listmodel);
        pane.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(listvy);
        // Adding scrollPane to frame
        pane.add(scrollPane, BorderLayout.NORTH);
        // Adding panel to frame
        pane.add(p, BorderLayout.SOUTH);


        frame.pack();
        frame.setVisible(true);
    }
}