public class Solution {
	public int removeDuplicates(int[] A) {
		if(A == null || A.length == 0) return 0;
		int tail = 0;
		int cur = tail + 1;
		while(cur < A.length) {
			if(A[cur] != A[tail]) {
				if(cur != tail + 1) {
					A[tail + 1] = A[cur];
				}
				tail++;
			}
			cur++;
		}
		return tail + 1;
	}
}
