package sudoku;

public class SudokuApplication {
	
	// Initializes a solver and a view
	public static void main(String[] args) {
		int size = 9; 
		ISudokuSolver solver = new SudokuSolver(size);
		
		new SudokuView(solver);
	}


}
