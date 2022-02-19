package Sudoku;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class SudokuGUI {
    public SudokuGUI(InterfaceSudokuSolver solver) {
        SwingUtilities.invokeLater(() -> createSudokuWindow(solver, 100, 300));
    }

    private void createSudokuWindow(InterfaceSudokuSolver solver, int width, int height) { // sudokuSolver is never used atm, the GUI is in other words not connected to the SudokuSolver
        JFrame frame = new JFrame("Sudoku");
        Container pane = frame.getContentPane();

        // making sudoku grid
        Border fieldBorder = BorderFactory.createLineBorder(Color.BLACK);

        JPanel grid = new JPanel(new GridLayout(9, 0));
        for (int i = 0; i < 81; ++i) {
            final JTextField field = new JTextField(2);
            field.setHorizontalAlignment(JTextField.CENTER); //Center text horizontally in the text field.
            field.setBorder(fieldBorder); //Add the colored border.
            grid.add(field);
        }

        JPanel centeredGrid = new JPanel(new GridBagLayout());
        centeredGrid.add(grid);

        // Creating buttons
        JButton BtnSolve = new JButton("Solve");
        JButton BtnClear = new JButton("Clear");

        // Creating a panel to add buttons
        JPanel p = new JPanel();
        // Adding buttons to panel
        p.add(BtnSolve);
        p.add(BtnClear);

        // Adding stuff to frame

        pane.add(centeredGrid, BorderLayout.CENTER);
        pane.add(p, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        /*
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

         */
    }
}