public class Solution {
	public void solve(char[][] board) {
		if(board == null || board.length < 3 || board[0].length < 3) return;

		int m = board.length;
		int n = board[0].length;
		Queue<Integer> queue = new LinkedList<Integer> ();

		for(int i = 0; i < m; i++) {
			enqueue(queue, n, i, 0);
			enqueue(queue, n, i, n - 1);
		}

		for(int j = 0; j < n; j++) {
			enqueue(queue, n, 0, j);
			enqueue(queue, n, m - 1, j);
		}

		while(!queue.isEmpty()) {
			int pos = queue.remove();
			int x = pos / n;
			int y = pos % n;
			if(x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O')
				continue;
			board[x][y] = 'M';
			enqueue(queue, n, x + 1, y);
			enqueue(queue, n, x - 1, y);
			enqueue(queue, n, x, y + 1);
			enqueue(queue, n, x, y - 1);
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

	private void enqueue(Queue<Integer> queue, int n, int x, int y) {
		queue.add(x * n + y);
	}
}
