
public class SudokuSolutionValidator implements Runnable {
	
	static int[][] sudokuSolution = {
			{4,3,1,5,7,9,6,8,2},
			{7,2,8,3,4,6,1,5,9},
			{6,5,9,2,8,1,7,4,3},
			{8,6,2,1,3,5,9,7,4},
			{9,1,4,8,6,7,2,3,5},
			{3,7,5,9,2,4,8,6,1},
			{1,9,7,6,5,3,4,2,8},
			{2,4,3,7,9,8,5,1,6},
			{5,8,6,4,1,2,3,9,7}
	};
	
	public static boolean solutionIsValid = true;

	public static void main(String[] args) {

		solutionIsValid = true;
		
		Thread mainThread = new Thread(new SudokuSolutionValidator());
		mainThread.start();

	}
	
	public void run() {
		
		for(int i = 0; i < sudokuSolution.length; i++) { // Checks if all numbers are between 1 and 9
			for(int j = 0; j < sudokuSolution[i].length; j++) {
				if(sudokuSolution[i][j] < 1 || sudokuSolution[i][j] > 9) {
					solutionIsValid = false;
				}
			}
		}
		
		if(solutionIsValid) {
			Thread col = new Thread(new SudokuSolutionValidator.ColumnValidator());
			Thread row = new Thread(new SudokuSolutionValidator.RowValidator());
			Thread grid1 = new Thread(new SudokuSolutionValidator.Grid1Validator());
			Thread grid2 = new Thread(new SudokuSolutionValidator.Grid2Validator());
			Thread grid3 = new Thread(new SudokuSolutionValidator.Grid3Validator());
			Thread grid4 = new Thread(new SudokuSolutionValidator.Grid4Validator());
			Thread grid5 = new Thread(new SudokuSolutionValidator.Grid5Validator());
			Thread grid6 = new Thread(new SudokuSolutionValidator.Grid6Validator());
			Thread grid7 = new Thread(new SudokuSolutionValidator.Grid7Validator());
			Thread grid8 = new Thread(new SudokuSolutionValidator.Grid8Validator());
			Thread grid9 = new Thread(new SudokuSolutionValidator.Grid9Validator());
			
			col.start();
			row.start();
			grid1.start();
			grid2.start();
			grid3.start();
			grid4.start();
			grid5.start();
			grid6.start();
			grid7.start();
			grid8.start();
			grid9.start();
			
			try {
				col.join();
				row.join();
				grid1.join();
				grid2.join();
				grid3.join();
				grid4.join();
				grid5.join();
				grid6.join();
				grid7.join();
				grid8.join();
				grid9.join();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		if(solutionIsValid) {
			System.out.println();
			System.out.println("Solution is valid");
		} else {
			System.out.println();
			System.out.println("Solution is invalid");
		}
		
	}
	
	private class ColumnValidator implements Runnable { // Checks Columns
		
		public void run() {
			
			for(int j = 0; j < sudokuSolution.length; j++) {
				
				int[] column = new int[sudokuSolution.length];
				for(int i = 0; i < sudokuSolution.length; i++) {
					column[i] = sudokuSolution[i][j];
				}
				
				if (!arrayIsValid(column)) {
					solutionIsValid = false;
					System.out.println("Column "+(j+1)+" is invalid");
				} else {
					System.out.println("Column "+(j+1)+" is valid");
				}
				
			}
			
		}
		
	}
	
	private class RowValidator implements Runnable { // Checks Rows
		
		public void run() {

			for(int i = 0; i < sudokuSolution.length; i++) {
				
				int[] row = sudokuSolution[i];
				if (!arrayIsValid(row)) {
					solutionIsValid = false;
					System.out.println("Row "+(i+1)+" is invalid");
				} else {
					System.out.println("Row "+(i+1)+" is valid");
				}
				
			}
			
		}
		
	}
	
	private class Grid1Validator implements Runnable { // Checks 3 by 3 Grid

		int starti = 0; 
		int startj = 0; // top left grid
		
		public void run() {
			
			int[] grid = new int[9];
			int count = 0;
			
			for(int i = starti; i < starti+3; i++) {
				for(int j = startj; j < startj+3; j++) {
					grid[count++] = sudokuSolution[i][j];
				}
			}
			
			if (!arrayIsValid(grid)) {
				solutionIsValid = false;
				System.out.println("Grid 1 is invalid");
			} else {
				System.out.println("Grid 1 is valid");
			}
			
		}
		
	}

	private class Grid2Validator implements Runnable {

		int starti = 0; 
		int startj = 3; // top center grid
		
		public void run() {

			int[] grid = new int[9];
			int count = 0;
			
			for(int i = starti; i < starti+3; i++) {
				for(int j = startj; j < startj+3; j++) {
					grid[count++] = sudokuSolution[i][j];
				}
			}
			
			if (!arrayIsValid(grid)) {
				solutionIsValid = false;
				System.out.println("Grid 2 is invalid");
			} else {
				System.out.println("Grid 2 is valid");
			}
			
		}
		
	}

	private class Grid3Validator implements Runnable {

		int starti = 0; 
		int startj = 6; // top right grid
		
		public void run() {

			int[] grid = new int[9];
			int count = 0;
			
			for(int i = starti; i < starti+3; i++) {
				for(int j = startj; j < startj+3; j++) {
					grid[count++] = sudokuSolution[i][j];
				}
			}
			
			if (!arrayIsValid(grid)) {
				solutionIsValid = false;
				System.out.println("Grid 3 is invalid");
			} else {
				System.out.println("Grid 3 is valid");
			}
			
		}
		
	}

	private class Grid4Validator implements Runnable {

		int starti = 3; 
		int startj = 0; // middle left grid
		
		public void run() {

			int[] grid = new int[9];
			int count = 0;
			
			for(int i = starti; i < starti+3; i++) {
				for(int j = startj; j < startj+3; j++) {
					grid[count++] = sudokuSolution[i][j];
				}
			}
			
			if (!arrayIsValid(grid)) {
				solutionIsValid = false;
				System.out.println("Grid 4 is invalid");
			} else {
				System.out.println("Grid 4 is valid");
			}
			
		}
		
	}

	private class Grid5Validator implements Runnable {

		int starti = 3; 
		int startj = 3; // middle center grid
		
		public void run() {

			int[] grid = new int[9];
			int count = 0;
			
			for(int i = starti; i < starti+3; i++) {
				for(int j = startj; j < startj+3; j++) {
					grid[count++] = sudokuSolution[i][j];
				}
			}
			
			if (!arrayIsValid(grid)) {
				solutionIsValid = false;
				System.out.println("Grid 5 is invalid");
			} else {
				System.out.println("Grid 5 is valid");
			}
			
		}
		
	}

	private class Grid6Validator implements Runnable {

		int starti = 3; 
		int startj = 6; // middle right grid
		
		public void run() {

			int[] grid = new int[9];
			int count = 0;
			
			for(int i = starti; i < starti+3; i++) {
				for(int j = startj; j < startj+3; j++) {
					grid[count++] = sudokuSolution[i][j];
				}
			}
			
			if (!arrayIsValid(grid)) {
				solutionIsValid = false;
				System.out.println("Grid 6 is invalid");
			} else {
				System.out.println("Grid 6 is valid");
			}
			
		}
		
	}

	private class Grid7Validator implements Runnable {

		int starti = 6; 
		int startj = 0; // bottom left grid
		
		public void run() {

			int[] grid = new int[9];
			int count = 0;
			
			for(int i = starti; i < starti+3; i++) {
				for(int j = startj; j < startj+3; j++) {
					grid[count++] = sudokuSolution[i][j];
				}
			}
			
			if (!arrayIsValid(grid)) {
				solutionIsValid = false;
				System.out.println("Grid 7 is invalid");
			} else {
				System.out.println("Grid 7 is valid");
			}
			
		}
		
	}

	private class Grid8Validator implements Runnable {

		int starti = 6; 
		int startj = 3; // bottom center grid
		
		public void run() {

			int[] grid = new int[9];
			int count = 0;
			
			for(int i = starti; i < starti+3; i++) {
				for(int j = startj; j < startj+3; j++) {
					grid[count++] = sudokuSolution[i][j];
				}
			}
			
			if (!arrayIsValid(grid)) {
				solutionIsValid = false;
				System.out.println("Grid 8 is invalid");
			} else {
				System.out.println("Grid 8 is valid");
			}
			
		}
		
	}

	private class Grid9Validator implements Runnable {

		int starti = 6; 
		int startj = 6; // bottom center grid
		
		public void run() {

			int[] grid = new int[9];
			int count = 0;
			
			for(int i = starti; i < starti+3; i++) {
				for(int j = startj; j < startj+3; j++) {
					grid[count++] = sudokuSolution[i][j];
				}
			}
			
			if (!arrayIsValid(grid)) {
				solutionIsValid = false;
				System.out.println("Grid 9 is invalid");
			} else {
				System.out.println("Grid 9 is valid");
			}
			
		}
		
	}
	
	public boolean arrayIsValid(int[] arr) {
		
		boolean[] boo = new boolean[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			boo[arr[i]-1] = true;
		}
		
		for(int i = 0; i < boo.length; i++) {
			if(!boo[i]) return false;
		}
		
		return true;
	}
	
}