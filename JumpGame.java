public class Solution {
	public boolean canJump(int[] A) {
		if(A == null || A.length ==	0)
			return false;
		int maxIndex = 0;
		int pos = 0;
		while(pos < A.length && pos <= maxIndex) {
			maxIndex = Math.max(maxIndex, A[pos] + pos);
			if(maxIndex >= A.length - 1)
				return true;
			pos++;
		}
		return false;
	}
}
