public class Solution {
	public int maxProduct(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		int maxEndingHere = A[0];
		int minEndingHere = A[0];
		int maxProduct = A[0];
		for(int i = 1; i < A.length; i++) {
			if(A[i] >= 0) {
				maxEndingHere = Math.max(maxEndingHere * A[i], A[i]);
				minEndingHere = Math.min(minEndingHere * A[i], A[i]);
			} else {
				int preMaxEndingHere = maxEndingHere;
				maxEndingHere = Math.max(minEndingHere * A[i], A[i]);
				minEndingHere = Math.min(preMaxEndingHere * A[i], A[i]);
			}
			maxProduct = Math.max(maxProduct, maxEndingHere);
		}
		return maxProduct;
	}
}
