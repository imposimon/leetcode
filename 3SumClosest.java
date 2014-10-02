public class Solution {
	public int threeSumClosest(int[] num, int target) {
		if(num == null || num.length < 3)
			return Integer.MAX_VALUE;

		int minDiff = Integer.MAX_VALUE;
		int closest = Integer.MAX_VALUE;
		Arrays.sort(num);
		for(int i = 0; i < num.length - 2; i++) {
			int j = i + 1;
			int k = num.length - 1;
			while(j < k) {
				int curDiff = num[i] + num[j] + num[k] - target;	
				if(curDiff == 0)
					return target;
				else {
					if(Math.abs(curDiff) < minDiff) {
						minDiff = Math.abs(curDiff);
						closest = num[i] + num[j] + num[k];
					}

					if(curDiff < 0)
						j++;
					else
						k--;
				}
			}
		}
		return closest;
	}
}
