public class Solution {
	public void solveSudoku(char[][] board) {
		solve(board);	
	}

	private boolean solve(char[][] board) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(board[i][j] != '.') continue;
				for(int k = 1; k <= 9; k++) {
					board[i][j] = (char)('0' + k);
					if(isValid(board, i, j) && solve(board)) {
						return true;
					}
					board[i][j] = '.';
				}
				return false;
			}
		}
		return true;
	}

	private boolean isValid(char[][] board, int row, int col) {
		for(int i = 0; i < 9; i++) {
			if(i != row && board[i][col] == board[row][col])
				return false;
		}

		for(int j = 0; j < 9; j++) {
			if(j != col && board[row][j] == board[row][col])
				return false;
		}

		for(int i = 3 * (row / 3); i < 3 * (row / 3 + 1); i++) {
			for(int j = 3 * (col / 3); j < 3 * (col / 3 + 1); j++) {
				if(i == row && j == col) continue;
				if(board[i][j] == board[row][col])
					return false;
			}
		}
		return true;
	}
}
