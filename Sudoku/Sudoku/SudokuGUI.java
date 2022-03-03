package Sudoku;

import javax.swing.*;
import java.awt.*;
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
        moGUL(fields);
        JPanel centeredGrid = new JPanel(new GridBagLayout());
        centeredGrid.add(grid);

        // creating buttons and adding ActionListeners
        JButton BtnSolve = new JButton("Solve");
        BtnSolve.addActionListener(e -> {
            //System.out.println("Mögggg");
            //if (solver.test==false) {
              //  System.out.println("Mögggg");
               // JOptionPane.showMessageDialog(null, "Fuck off you little rat of an Indian");
            //} else {



            ///solver.validBoard(solver.board);



            //if (solver.solve(solver.board)) {
           //     System.out.println("Solved successfully!");
            //}
            //else {
            //    System.out.println("Unsolvable board :(");
            //}
            try {
                System.out.println("Mögggg");
                getField(solver, fields);
                System.out.println("Mögel");
                solver.solve(solver.board); // de e fel på solve för hänger sig här när man ger två siffror som är likadana
                System.out.println("fuuck");
                update(solver, fields);
                System.out.println("luul");
            } catch (Exception t) {
                System.out.println("miffop");
                JOptionPane.showMessageDialog(null, "Fuck off you little rat of an Indian");
                solver.clear();
                update(solver, fields);
            }
            //}
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

    private void getField(SudokuSolver solver, JTextField[] fields) {
        int place = 0;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (fields[place].getText().equals("")) {
                    solver.board[row][col] = 0;
                    place++;
                } else {
                    solver.board[row][col] = Integer.parseInt(fields[place].getText());
                    place++;
                }
            }
        }
    }

    private void moGUL(JTextField[] fields){
        int[] COLORED_SQUARES = {0,1,2,9,10,11,18,19,20,6,7,8,15,16,17,24,25,26,30,31,32,39,40,41,48,49,50,54,55,56,63,64,65
        ,72,73,74,60,61,62,69,70,71,78,79,80};

        for(int i : COLORED_SQUARES){
            fields[i].setBackground(Color.ORANGE);
        }
    }
}