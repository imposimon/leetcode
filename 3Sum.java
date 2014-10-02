public class Solution {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new LinkedList<List<Integer>> ();
		if(num == null || num.length < 3)
			return result;

		Arrays.sort(num);
		for(int i = 0; i < num.length - 2; i++) {
			if(i > 0 && num[i] == num[i - 1])
				continue;
			int j = i + 1;
			int k = num.length - 1;
			while(j < k) {
				if(j > i + 1 && num[j] == num[j - 1]) {
					j++; continue;
				}
				if(num[j] + num[k] == - num[i]) {
					result.add(Arrays.asList(num[i], num[j], num[k]));
					j++;
					k--;
				} else if(num[j] + num[k] < - num[i]) {
					j++;
				} else {
					k--;
				}
			}
		}
		return result;
	}
}
