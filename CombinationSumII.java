public class Solution {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> result = new LinkedList<List<Integer>> ();
		Arrays.sort(num);
		helper(result, new LinkedList<Integer>(), num, 0, target);
		return result;
	}

	public void helper(List<List<Integer>> result, List<Integer> tmp, int[] num, int pos, int target) {
		if(target == 0) {
			result.add(new LinkedList<Integer>(tmp));
			return;
		}
		if(pos >= num.length || num[pos] > target)
			return;

		tmp.add(num[pos]);
		helper(result, tmp, num, pos + 1, target - num[pos]);
		tmp.remove(tmp.size() - 1);
		int cur = num[pos];
		while(pos < num.length && num[pos] == cur) {
			pos++;
		}
		helper(result, tmp, num, pos, target);	
	}
}
