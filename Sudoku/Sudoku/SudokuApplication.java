package Sudoku;

public class SudokuApplication {
    public static void main(String[] args) {
        InterfaceSudokuSolver sudoku = new SudokuSolver();
        new SudokuGUI();
        /*public static void main(String[] args) {

        Sudoku sudoku = new Sudoku();

        if(sudoku.solve(board)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
        sudoku.solve(board);
        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }
     */
    }
}
