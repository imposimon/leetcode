public class Solution {
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> result = new LinkedList<List<Integer>> ();
		Arrays.sort(num);
		helper(result, new LinkedList<Integer>(), new boolean[num.length], num);
		return result;
	}


	public void helper(List<List<Integer>> result, List<Integer> tmp, boolean[] used, int[] num) {
		if(tmp.size() == num.length) {
			result.add(new LinkedList<Integer>(tmp));
			return;
		}
		for(int i = 0; i < num.length; i++) {
			if(used[i] || i > 0 && num[i - 1] == num[i] && used[i - 1]) continue;
			used[i] = true;
			tmp.add(num[i]);
			helper(result, tmp, used, num);
			tmp.remove(tmp.size() - 1);
			used[i] = false;
		}
	}
}
