public class Solution {
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> result = new LinkedList<List<Integer>> ();
		if(num == null || num.length < 4)
			return result;
		Arrays.sort(num);
		for(int i = 0; i < num.length - 3; i++) {
			if(i > 0 && num[i] == num[i - 1]) continue;
			for(int j = i + 1; j < num.length - 2; j++) {
				if(j > i + 1 && num[j] == num[j - 1]) continue;
				int k = j + 1;
				int l = num.length - 1;
				while(k < l) {
					if(k > j + 1 && num[k] == num[k - 1]) {
						k++; continue;
					}
					int curSum = num[i] + num[j] + num[k] + num[l];
					if(curSum == target) {
						result.add(Arrays.asList(num[i], num[j], num[k], num[l]));
						k++;
						l--;
					} else if(curSum < target) {
						k++;
					} else {
						l--;
					}
				}
			}
		}
		return result;
	}
}
