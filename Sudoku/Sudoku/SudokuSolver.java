package Sudoku;

public class SudokuSolver implements InterfaceSudokuSolver {

    private static final int gridSize = 9;

    public int[][] board = {
            {1,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,2,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0}
    };

    private boolean isNumInRow(int number, int row) {
        for (int i = 0; i < gridSize; i++) {
            if (get(row, i) == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumInCol(int number, int column) {
        for (int i = 0; i < gridSize; i++) {
            if (get(i, column) == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumInBox(int number, int row, int column) {
        int localBoxRow = row - row % 3; // räkna ut första raden i rutan
        int localBoxColumn = column - column % 3; // räkna ut första kolumnen

        for (int i = localBoxRow; i < localBoxRow + 3; i++) {  // gå igenom rutans 3 rader
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++) { // gå igenom rutans 3 kolumner
                if (get(i, j) == number) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isValid(int[][] board, int number, int row, int column) {
        return !isNumInRow(number, row) &&
                !isNumInCol(number, column) &&
                !isNumInBox(number, row, column);
    }

    // bara ngt jag testade att skriva, vi kan nog bara ta bort den för vår kod fungerar inte för funktionen ändå
    public void validBoard(int[][] board){
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                System.out.println(isValid(board, board[row][col], row, col));
                if (!isValid(board, board[row][col], row, col)) {
                    System.out.println("valid"); // will always reach this statement kek
                } else {
                    System.out.println("invalid");
                }
            }
        }
    }

    public boolean solve(int[][] board) {
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (board[row][col] == 0) {
                    for (int numberToTry = 1; numberToTry <= gridSize; numberToTry++) {
                        if (isValid(board, numberToTry, row, col)) {
                            System.out.println(1);
                            add(row, col, numberToTry);

                            if (solve(board)) {
                                System.out.println(2);

                                return true;
                            }
                            else {
                                System.out.println(3);

                                remove(row, col);
                            }
                        }
                    }
                    System.out.println(4);

                    return false;
                    //System.out.println("Mökmonstret");
                }
            }
        }
        System.out.println(5);

        //System.out.println("Mökmonstret");
        return true;
    }

    @Override
    public void add(int row, int col, int digit) {
        checkArgs(row, col, digit);
        board[row][col] = digit;

    }

    @Override
    public void remove(int row, int col) {
        checkArgs(row, col);
        board[row][col] = 0;
    }

    @Override
    public int get(int row, int col) {
        checkArgs(row, col);
        return board[row][col];
    }


    public boolean isAllValid() {
        boolean bool = false;
        for(int r = 0; r < gridSize; r++) {
            for(int c = 0; c < gridSize; c++) {
                int num = board[r][c];
                bool =  !isNumInRow(num, r) &&
                        !isNumInCol(num, c) &&
                        !isNumInBox(num, r, c);
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

    /**
     * @param args  Integers to compare to dimension
     * Helper method to check that all arguments are within the dimension
     */
    private void checkArgs(int... args) {
        for (int a : args) {
            if (a > gridSize || a < 0) {
                throw new IllegalArgumentException();
            }

        }
    }

}