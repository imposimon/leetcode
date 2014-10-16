public class Solution {
	public int search(int[] A, int target) {
		if(A == null || A.length == 0)
			return -1;
		int start = 0;
		int end = A.length - 1;
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(A[mid] == target)
				return mid;
			if(A[mid] < A[start]) {
				//pivot is on the left side of mid
				if(target > A[mid] && target <= A[end]) 
					start = mid + 1;
				else
					end = mid - 1;
			} else {
				//pivot is on the right side of mid
				if(target >= A[start] && target < A[mid])
					end = mid - 1;
				else
					start = mid + 1;
			}
		}
		return -1;
	}
}
