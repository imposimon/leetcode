public class Solution {
	public int largestRectangleArea(int[] height) {
		if(height == null || height.length == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer> ();
		int maxArea = 0;
		int i = 0;
		while(i < height.length) {
			if(stack.isEmpty() || height[stack.peek()] <= height[i]) {
				stack.push(i);
				i++;
			} else {
				int curHeight = height[stack.pop()];
				int width = (stack.isEmpty()) ? i : (i - stack.peek() - 1);
				maxArea = Math.max(maxArea, curHeight * width);
			}
		}
		while(!stack.isEmpty()) {
			int curHeight = height[stack.pop()];
			int width = (stack.isEmpty()) ? i : (i - stack.peek() - 1);
			maxArea = Math.max(maxArea, curHeight * width);
		}
		return maxArea;
	}
}
