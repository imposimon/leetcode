public class Solution {
	public void sortColors(int[] A) {
		if(A == null || A.length == 0)
			return;
		int start = 0;
		int end = A.length - 1;
		int i = 0;
		while(i <= end) {
			if(A[i] == 0) {
				swap(A, i, start);
				start++;
				i++;
			} else if(A[i] == 1) {
				i++;
			} else if(A[i] == 2) {
				swap(A, i, end);
				end--;
			}
		}
	}

	private void swap(int[] A, int i, int j) {
		if(i == j) return;
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}
