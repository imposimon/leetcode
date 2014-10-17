public class Solution {
	public int totalNQueens(int n) {
		int[] result = new int[1];
		int[] cols = new int[n];
		helper(result, colss, 0, n);
		return result[0];
	}

	public int helper(int[] num, int[] cols, int r, int n) {
		if(r == n) {
			num[0] += 1;
			return;
		}
		for(int i = 0; i < n; i++) {
			cols[r] = i;
			if(isValid(cols, r)) {
				helper(num, cols, r + 1, n);
			}
		}
	}

	public boolean isValid(int[] cols, int r) {
		for(int i = 0; i < r; i++) {
			if(cols[i] == cols[r] || Math.abs(i - r) == Math.abs(cols[i] - cols[r]))
				return false;
		}
		return true;
	}
}
