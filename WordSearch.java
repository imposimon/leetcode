public class Solution {
	public boolean exist(char[][] board, String word) {
		if(board == null || board.length == 0 || word == null || word.length() == 0)
			return false;
		boolean visited[][] = new boolean[board.length][board[0].length];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(helper(board, i, j, word, 0, visited))
					return true;
			}
		}
		return false;
	}

	public boolean helper(char[][] board, int i, int j, String word, int pos, boolean[][] visited) {
		if(pos == word.length())
			return true;

		if(i < 0 || i >= board.length ||
			j < 0 || j >= board[i].length)
			return false;

		if(board[i][j] != word.charAt(pos) || visited[i][j]) {
			return false;
		} else {
			visited[i][j] = true;
			if(helper(board, i + 1, j, word, pos + 1, visited) ||
				helper(board, i, j + 1, word, pos + 1, visited) ||
				helper(board, i - 1, j, word, pos + 1, visited) ||
				helper(board, i, j - 1, word, pos + 1, visited))
				return true;
			else {
				visited[i][j] = false;
				return false;
			}
		}

	}
}
