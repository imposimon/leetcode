public class Solution {
	public boolean search(int[] A, int target) {
		if(A == null || A.length == 0)
			return false;
		return helper(A, target, 0, A.length - 1);
	}

	public boolean helper(int[] A, int target, int start, int end) {
		if(start > end) return false;
		int mid = start + (end - start) / 2;
		if(A[mid] == target) return true;

		if(A[mid] < A[start]) {
			if(target > A[mid] && target <= A[end])
				return helper(A, target, mid + 1, end);
			else
				return helper(A, target, start, mid - 1);
		} else if(A[mid] > A[start])  {
			if(target >= A[start] && target < A[mid])
				return helper(A, target, start, mid - 1);
			else
				return helper(A, target, mid + 1, end);
		} else {
			return helper(A, target, start, mid - 1) || helper(A, target, mid + 1, end);
		}
	}
}
