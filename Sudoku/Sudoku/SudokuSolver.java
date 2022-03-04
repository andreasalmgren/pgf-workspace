package Sudoku;

import javax.swing.*;
import java.util.*;

public class SudokuSolver implements InterfaceSudokuSolver {

    private static final int gridSize = 9;

    public int[][] board = {
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

    /**
     * Checks if a number is in row
     * @param number
     * @param row
     * @return true if yes, false if no
     */

    public boolean isNumInRow(int number, int row) {
        for (int i = 0; i < gridSize; i++) {
            if (get(row, i) == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a number appears anywhere else in the column
     * @param number
     * @param column
     * @return true if yes, false if no
     */
    public boolean isNumInCol(int number, int column) {
        for (int i = 0; i < gridSize; i++) {
            if (get(i, column) == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if number appears anywhere in the 3x3 box
     * @param number
     * @param row
     * @param column
     * @return true if yes, false if no
     */
    public boolean isNumInBox(int number, int row, int column) {
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

    /**
     * Checks if the number is valid to place at a certain position
     * @param board     The board
     * @param number
     * @param row       The row
     * @param column
     * @return true if not, false if yes
     */
    public boolean isValid(int[][] board, int number, int row, int column) {
        return  !isNumInRow(number, row)&&
                !isNumInCol(number, column) &&
                !isNumInBox(number, row, column);
    }

    /**
     * Solves sudoku
     * @return the recursive func solve with param board
     */
    @Override
    public boolean solve() {
        return solve(board);
    }

    /**
     * @param board     The board
     * Tries to solve the sudoku recursively
     * @return
     */
    private boolean solve(int[][] board) {
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (board[row][col] == 0) {
                    for (int numberToTry = 1; numberToTry <= gridSize; numberToTry++) {
                        if (isValid(this.board, numberToTry, row, col)) {
                            add(row, col, numberToTry);

                            if (solve(board)) {
                                return true;
                            }
                            else {
                                remove(row, col);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Insert value digit in row, col in board
     * @param row   The row
     * @param col   The column
     * @param digit The digit to insert in box row, col
     */
    @Override
    public void add(int row, int col, int digit) {
        checkArgs(row, col, digit);
        board[row][col] = digit;
    }

    /**
     * Set value at row, col in board to 0
     * @param row   The row
     * @param col   The col
     */
    @Override
    public void remove(int row, int col) {
        checkArgs(row, col);
        board[row][col] = 0;
    }

    /**
     * Get value from row, col in board
     * @param row   The row
     * @param col   The col
     * @return      Value
     */
    @Override
    public int get(int row, int col) {
        checkArgs(row, col);
        return board[row][col];
    }

    /**
     * Checks if all rows and cols in board are valid
     * @return true or false depending on board state
     */
    public boolean isAllValid() {
        //System.out.println(isValid(this.board, 1, 5, 1));
        //Returnerar den senaste checkade cellen
        //boolean bool = true;
        for(int r = 0; r < gridSize; r++) {
            for(int c = 0; c < gridSize; c++) {
                int num = board[r][c];
                System.out.println(num);
                if(num!=0) {

                    remove(r,c);
                    if(!isValid(board, num, r, c)){
                        board[r][c] = num;
                        return false;
                    }
                    else{
                        board[r][c] = num;
                    }
                }
            }
        }
        //Returnera true
        return true;
    }

    /**
     * Sets all values in current matrix to 0
     */
    @Override
    public void clear() {
        for(int r = 0; r < gridSize; r++) {
            for(int c = 0; c < gridSize; c++) {
                board[r][c] = 0;
            }
        }
    }

    /**
     * Set board to m
     * @param m the matrix with the digits to insert
     */
    @Override
    //Kollar inte efter fel dimensioner på matrisen m?
    public void setMatrix(int[][] m) {
        board = m;
    }

    /**
     * Returns board
     * @return this.board
     */
    @Override
    public int[][] getMatrix() {
        return board;
    }

    /**
     * Helper method to check that all arguments are within the dimension
     * @param args  Integers to compare to dimension
     */
    private void checkArgs(int... args) {
        for (int a : args) {
            if (a > gridSize || a < 0) {
                throw new IllegalArgumentException();
            }

        }
    }

}