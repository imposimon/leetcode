public class Solution {
	public int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix.length == 0) return 0;
		int[][] histograms = new int[matrix.length][matrix[0].length];
		for(int j = 0; j < matrix[0].length; j++) {
			histograms[0][j] = (matrix[0][j] == '1') ? 1 : 0;
		}
		for(int i = 1; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				histograms[i][j] = (matrix[i][j] == '1') ? histograms[i - 1][j] + 1 : 0;
			}
		}
		int maxArea = 0;
		for(int[] histogram : histograms) {
			maxArea = Math.max(maxArea, maxArea(histogram));
		}
		return maxArea;
	}

	public int maxArea(int[] height) {
		if(height == null || height.length == 0)
			return 0;
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		while(i < height.length) {
			if(stack.isEmpty() || height[stack.peek()] <= height[i]) {
				stack.push(i++);
			} else {
				int h = height[stack.pop()];
				int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
				maxArea = Math.max(maxArea, h * width);
			}
		}
		while(!stack.isEmpty()) {
			int h = height[stack.pop()];
			int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
			maxArea = Math.max(maxArea, h * width);
		}
		return maxArea;
	}

}
