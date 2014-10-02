public class Solution {
	public int jump(int[] A) {
		if(A == null || A.length == 0)
			return -1 ;

		int lastFurthest = 0;
		int curFurthest = 0;
		int minStep = 0;
		for(int i = 0; i < A.length; i++) {
			if(i > lastFurthest) {
				if(i > curFurthest) return -1;
				lastFurthest = curFurthest;
				minStep ++;
			}
			curFurthest = Math.max(curFurthest, A[i] + i);
		}
		return minStep;
	}
}
