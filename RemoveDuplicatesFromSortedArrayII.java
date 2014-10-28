public class Solution {
	public int removeDuplicates(int[] A) {
		if(A == null || A.length == 0) return 0;
		int tail = 0;
		int cur = tail + 1;
		boolean appeared = false;
		while(cur < A.length) {
			if(A[cur] != A[tail]) {
				A[++tail] = A[cur];
				appeared = false;
			} else if(!appeared) {
				A[++tail] = A[cur];
				appeared = true;
			}
			cur++;
		}
		return tail + 1;
	}
}
