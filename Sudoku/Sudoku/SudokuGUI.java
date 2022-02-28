package Sudoku;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SudokuGUI {
    public SudokuGUI(SudokuSolver solver) {
        SwingUtilities.invokeLater(() -> createSudokuWindow(solver));
    }

    private void createSudokuWindow(SudokuSolver solver) {
        JFrame frame = new JFrame("Sudoku");
        Container pane = frame.getContentPane();

        // making sudoku grid
        JTextField[] fields = new JTextField[81];
        JPanel grid = new JPanel(new GridLayout(9, 9));
        for (int i = 0; i < fields.length; i++) {
            fields[i] = new JTextField(2);
            grid.add(fields[i]);
        }
        JPanel centeredGrid = new JPanel(new GridBagLayout());
        centeredGrid.add(grid);

        // creating buttons and adding ActionListeners
        JButton BtnSolve = new JButton("Solve");
        BtnSolve.addActionListener(e -> {
            solver.solve(solver.board);
            update(solver, fields);
        });
        JButton BtnClear = new JButton("Clear");
        BtnClear.addActionListener(e -> {
            solver.clear();
            update(solver, fields);
        });

        // creating a panel to add buttons
        JPanel p = new JPanel();

        // adding buttons to panel
        p.add(BtnSolve);
        p.add(BtnClear);

        // adding stuff to frame
        pane.add(centeredGrid, BorderLayout.CENTER);
        pane.add(p, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        // take values from initial board and put them in sudoku board
        update(solver, fields);
    }

    /**
     * Updates the JTextFields in the sudoku window
     * @param solver    the SudokuSolver instance
     * @param fields    the JTextField[]
     */
    private void update(SudokuSolver solver, JTextField[] fields) {
        int place = 0;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (solver.board[row][col] == 0) {
                    fields[place].setText("");
                    place++;
                } else {
                    fields[place].setText(Integer.toString(solver.board[row][col]));
                    place++;
                }
            }
        }
    }
}