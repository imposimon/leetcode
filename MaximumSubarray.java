public class Solution {
	public int maxSubArray(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		int maxSum = A[0];
		int maxEndingHere = A[0];
		for(int i = 1; i < A.length; i++) {
			maxEndingHere = (maxEndingHere + A[i] > A[i]) ? maxEndingHere + A[i] : A[i];
			if(maxEndingHere > maxSum)
				maxSum = maxEndingHere;
		}
		return maxSum;
	}
}
