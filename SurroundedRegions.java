public class Solution {
	public void solve(char[][] board) {
		if(board == null || board.length < 3 || board[0].length < 3) return;

		int m = board.length;
		int n = board[0].length;

		for(int i = 0; i < m; i++) {
			dfs(board, i, 0);
			dfs(board, i, n - 1);
		}

		for(int j = 0; j < n; j++) {
			dfs(board, 0, j);
			dfs(board, m - 1, j);
		}

		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(board[i][j] == 'O')
					board[i][j] = 'X';
				else if(board[i][j] == 'M')
					board[i][j] = 'O';
			}
		}
	}

	private void dfs(char[][] board, int i, int j) {
		int m = board.length;
		int n = board[0].length;
		if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O')
			return;

		board[i][j] = 'M';
		dfs(board, i + 1, j);
		dfs(board, i - 1, j);
		dfs(board, i, j + 1);
		dfs(board, i, j - 1);
	}


}
