public class Solution {
	public int maxArea(int[] height) {
		if(height == null || height.length < 2)
			return 0;
		
		int start = 0;
		int end = height.length - 1;
		int maxArea = 0;
		while(start < end) {
			int curArea = Math.min(height[start], height[end]) * (end - start);
			maxArea = Math.max(maxArea, curArea);
			if(height[start] < height[end])
				start ++;
			else
				end --;
		}
		return maxArea;
	}
}
