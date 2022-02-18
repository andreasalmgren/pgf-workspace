package Sudoku;

public class Sudoku implements ISudokuSolver{



    public static void main(String[] args) {

        Sudoku sudoku = new Sudoku();

        if(sudoku.solve()) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
        sudoku.solve();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int gridSize = 9;

    static int[][] board = {
            {1,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0}
    };





    private static boolean isNumInRow(int[][] board, int num, int row) {
        boolean contains = false;
        for(int i = 0; i < gridSize; i++) {
            if(board[row][i] == num) {
                contains = true;
            }
        }
        return contains;
    }

    private static boolean isNumInCol(int[][] board, int num, int col) {
        boolean contains = false;
        for(int i = 0; i < gridSize; i++) {
            if(board[i][col] == num) {
                contains = true;
            }
        }
        return contains;
    }

    private static boolean isNumInBox(int[][] board, int num, int row, int col) {
        boolean contains = false;
        int firstRow = row - row % 3;    // räkna ut första raden i rutan
        int firstCol = col - col % 3;   // räkna ut första kolumnen

        for(int r = 0; r < firstRow + 3; r++) {         // gå igenom rutans 3 rader
            for(int c = 0; c < firstCol + 3; c++) {    // gå igenom rutans 3 kolumner
                if(board[r][c] == num) {
                    contains = true;
                }
            }
        }
        return contains;
    }

    public boolean isValid(int[][] board, int num, int row, int col) {
        return  !isNumInRow(board, num, row) &&
                !isNumInCol(board, num, col) &&
                !isNumInBox(board, num, row, col);
    }

    @Override
    public boolean solve() {
        return solve(0,0);
    }


    private boolean solve(int r, int c) {
        for(int b = r; b < gridSize; b++) {
            for(int d = c; d < gridSize; d++) {
                if(board[b][d] == 0) {
                    for(int testNum = 1; testNum <= gridSize; testNum++) {
                        if(isValid(board, testNum, b, d)) {
                            board[b][d] = testNum;
                            solve(b+1, d+1);
                            if(solve()) {
                                return true;
                            }
                            else {
                                board[b][d] = 0;
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