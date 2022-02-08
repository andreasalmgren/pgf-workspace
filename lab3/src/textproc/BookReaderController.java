package textproc;
import javax.swing.*;
import java.awt.*;
import java.lang.reflect.GenericArrayType;
import java.util.List;
import java.util.Map;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

public class BookReaderController {
    public BookReaderController(GeneralWordCounter counter) {
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
    }

    private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane(); // pane är en behållarkomponent till vilken de övriga komponenterna (listvy, knappar etc.) ska läggas till.

        List<Map.Entry<String, Integer>> a = counter.getWordList();
        SortedListModel<Map.Entry<String, Integer>> listmodel = new SortedListModel(a);
        JList listvy = new JList(listmodel);
        pane.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(listvy);
        pane.add(scrollPane);

       

        frame.pack();
        frame.setVisible(true);
    }
}