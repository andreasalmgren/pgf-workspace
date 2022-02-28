package Sudoku;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class SudokuGUI {
    public SudokuGUI(SudokuSolver solver) {
        SwingUtilities.invokeLater(() -> createSudokuWindow(solver));
    }

    private void createSudokuWindow(SudokuSolver solver) { // sudokuSolver is never used atm, the GUI is in other words not connected to the SudokuSolver
        JFrame frame = new JFrame("Sudoku");
        Container pane = frame.getContentPane();

        // making sudoku grid

        JTextField[] fields = new JTextField[81];
        JPanel grid = new JPanel(new GridLayout(9, 9));
        for (int i = 0; i < fields.length; ++i) {
            fields[i] = new JTextField(2);
            grid.add(fields[i]);
            solver.clear();
        }

        int place = 0;
        for (int row = 0; row < 9; row++) {
           for(int col = 0; col < 9; col++){
               if (solver.board[row][col]==0) {
                   place++;
               } else {
                   fields[place].setText(Integer.toString(solver.board[row][col]));
                   place++;
               }
           }
        }

        JPanel centeredGrid = new JPanel(new GridBagLayout());
        centeredGrid.add(grid);

        // Creating buttons
        JButton BtnSolve = new JButton("Solve");
        JButton BtnClear = new JButton("Clear");
        BtnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                solver.clear();
            }
        });

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