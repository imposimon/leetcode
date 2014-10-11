public class Solution {
	public int firstMissingPositive(int[] A) {
		if(A == null || A.length == 0)
			return 1;
		int i = 0;
		while(i < A.length) {
			if(A[i] > 0 && A[i] <= A.length && A[i] - 1 != i && A[i] != A[A[i] - 1])
				swap(A, i, A[i] - 1);
			else
				i++;
		}

		i = 0;
		while(i < A.length) {
			if(A[i] - 1 != i)
				break;
			i++;
		}
		return i + 1;
	}

	private void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}
