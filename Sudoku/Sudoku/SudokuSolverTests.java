package Sudoku;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SudokuSolverTests {
    private SudokuSolver sudoku;
    private final int[][] testBoard = {
            {1,2,3,0,0,0,0,0,0},
            {4,5,6,7,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0}
    };


    @BeforeEach
    void setUp() {
        // Create empty Sudoku
        sudoku = new SudokuSolver();
    }

    @AfterEach
    void tearDown() {
        sudoku = null;
    }

    /**
     * Tests with an empty board
     */
    @Test
    void testEmpty() {
        //assertTrue(sudoku.solve());
    }

    // Alla publika metoder testas
    //Det finns jUnit-tester för olika
    //fall av sudokun:
           // • tomt sudoku
           //• det lösbara sudokut i uppgiftstexten
            // • olösliga sudokun
}