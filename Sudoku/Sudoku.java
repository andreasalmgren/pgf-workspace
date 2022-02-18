package Sudoku;

public class Sudoku implements SudokuSolver {

    public static void main(String[] args) {

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

    private static final int gridSize = 9;

    public static int[][] board = {
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0}
    };

    private static boolean isNumInRow(int[][] board, int number, int row) {
        for (int i = 0; i < gridSize; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumInCol(int[][] board, int number, int column) {
        for (int i = 0; i < gridSize; i++) {
            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumInBox(int[][] board, int number, int row, int column) {
        int localBoxRow = row - row % 3; // räkna ut första raden i rutan
        int localBoxColumn = column - column % 3; // räkna ut första kolumnen

        for (int i = localBoxRow; i < localBoxRow + 3; i++) {  // gå igenom rutans 3 rader
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++) { // gå igenom rutans 3 kolumner
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isValid(int[][] board, int number, int row, int column) {
        return !isNumInRow(board, number, row) &&
                !isNumInCol(board, number, column) &&
                !isNumInBox(board, number, row, column);
    }

    public boolean solve(int[][] board) {
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (board[row][col] == 0) {
                    for (int numberToTry = 1; numberToTry <= gridSize; numberToTry++) {
                        if (isValid(board, numberToTry, row, col)) {
                            board[row][col] = numberToTry;

                            if (solve(board)) {
                                return true;
                            }
                            else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void add(int row, int col, int digit) {
        board[row][col] = digit;
    }




    @Override
    public void remove(int row, int col) {
        board[row][col] = 0;
    }

    @Override
    public int get(int row, int col) {
        return board[row][col];
    }


    public boolean isAllValid() {
        boolean bool = false;
        for(int r = 0; r < gridSize; r++) {
            for(int c = 0; c < gridSize; c++) {
                int num = board[r][c];
                bool =  !isNumInRow(board, num, r) &&
                        !isNumInCol(board, num, c) &&
                        !isNumInBox(board, num, r, c);
            }
        }
        return bool;
    }

    @Override
    public void clear() {
        for(int r = 0; r < gridSize; r++) {
            for(int c = 0; c < gridSize; c++) {
                board[r][c] = 0;
            }
        }
    }

    @Override
    public void setMatrix(int[][] m) {
        board = m;
    }

    @Override
    public int[][] getMatrix() {
        return board;
    }

}