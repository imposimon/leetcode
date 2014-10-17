public class Solution {
	public List<String[]> solveNQueens(int n) {
		List<String[]> result = new LinkedList<String[]>();
		int[] cols = new int[n];
		helper(result, cols, 0, n);
		return result;
	}

	public void helper(List<String[]> result, int[] cols, int r, int n) {
		if(r == n) {
			result.add(generateResult(cols));
			return;
		}
		for(int i = 0; i < n; i++) {
			cols[r] = i;
			if(isValid(cols, r))
				helper(result, cols, r + 1, n);
		}
	}

	public boolean isValid(int[] cols, int r) {
		for(int i = 0; i < r; i++) {
			if(cols[i] == cols[r] || Math.abs(i - r) == Math.abs(cols[i] - cols[r]))	
				return false;
		}
		return true;
	}

	public String[] generateResult(int[] cols) {
		int n = cols.length;
		String[] result = new String[n];
		for(int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < n; j++) {
				if(cols[i] == j)
					sb.append('Q');
				else
					sb.append('.');
			}
			result[i] = sb.toString();
		}
		return result;
	}
}
