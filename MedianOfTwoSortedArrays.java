public class Solution {
	public double findMedianSortedArrays(int[] A, int[] B) {
		int len = 0;
		if(A != null) len += A.length;
		if(B != null) len += B.length;

		double median = 0.0;

		if(len % 2 == 0)
			median = (findKthOfSortedArrays(A, 0, B, 0, len/2) + findKthOfSortedArrays(A, 0, B, 0, len/2 + 1)) / 2.0;
		else
			median = findKthOfSortedArrays(A, 0, B, 0, len/2 + 1);

		return median;
	}

	public int findKthOfSortedArrays(int[] A, int aStart, int[] B, int bStart, int k) {
		if(A == null && B == null)
			return 0;
		if(A == null || aStart >= A.length)
			return B[bStart + k - 1];
		if(B == null || bStart >= B.length)
			return A[aStart + k - 1];
		if(k == 1)
			return Math.min(A[aStart], B[bStart]);

		int aKey = (aStart + k/2 - 1 < A.length) ? A[aStart + k/2 - 1] : Integer.MAX_VALUE;
		int bKey = (bStart + k/2 - 1 < B.length) ? B[bStart + k/2 - 1] : Integer.MAX_VALUE;	

		if(aKey < bKey)
			return findKthOfSortedArrays(A, aStart + k/2, B, bStart, k - k/2);
		else	
			return findKthOfSortedArrays(A, aStart, B, bStart + k/2, k - k/2);
	}
}
