class Solution {
    
    // Check if it's safe to place the digit
    public static boolean isSafe(int[][] board, int row, int col, int digit) {
        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) {
                return false;
            }
        }
        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == digit) {
                return false;
            }
        }
        // Check 3x3 grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    // Solving Sudoku with backtracking
    public static boolean sudokuSolver(int[][] board, int row, int col) {
        // Base case: If we've filled all rows, the board is solved
        if (row == 9) {
            return true;
        }
        
        // Move to the next cell (next column)
        int nextRow = row;
        int nextCol = col + 1;
        
        if (col == 8) {
            nextRow++;
            nextCol = 0;
        }
        
        // If the current cell is already filled, skip it
        if (board[row][col] != 0) {
            return sudokuSolver(board, nextRow, nextCol);
        }
        
        // Try digits 1 through 9 in the empty cell
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(board, row, col, digit)) {
                board[row][col] = digit;
                if (sudokuSolver(board, nextRow, nextCol)) {
                    return true;
                }
                // Backtrack
                board[row][col] = 0;
            }
        }
        
        // If no valid digit is found, return false
        return false;
    }

    // Main method to solve Sudoku
    public void solveSudoku(char[][] board) {
        int[][] boardInt = new int[9][9];
        
        // Convert char[][] to int[][] for internal processing
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    boardInt[i][j] = 0; // Empty cell
                } else {
                    boardInt[i][j] = board[i][j] - '0'; // Convert char to int
                }
            }
        }

        // Solve the Sudoku
        sudokuSolver(boardInt, 0, 0);
        
        // Convert int[][] back to char[][] to print the result
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = (char) (boardInt[i][j] + '0'); // Convert int back to char
            }
        }
        
        // Print the solved Sudoku board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
