public class Solution {
	public int trap(int[] A) {
		if(A == null || A.length < 3)
			return 0;
		int[] dp = new int[A.length];
		int maxHeight = A[0];
		for(int i = 1; i < A.length - 1; i++) {
			dp[i] = maxHeight;
			maxHeight = Math.max(maxHeight, A[i]);
		}
		maxHeight = A[A.length - 1];
		int water = 0;
		for(int i = A.length - 2; i > 0; i--) {
			int curWater = Math.min(dp[i], maxHeight) - A[i];
			water += Math.max(curWater, 0);
			maxHeight = Math.max(maxHeight, A[i]);
		}
		return water;
	}
}
