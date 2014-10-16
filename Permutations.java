public class Solution {
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new LinkedList<List<Integer>> ();
		helper(result, new LinkedList<Integer>(), new boolean[num.length], num);
		return result;
	}

	public void helper(List<List<Integer>> result, List<Integer> tmp, boolean[] used, int[] num) {
		if(tmp.size() == num.length) {
			result.add(new LinkedList<Integer>(tmp));
			return;
		}
		for(int i = 0; i < num.length; i++) {
			if(used[i]) continue;
			used[i] = true;
			tmp.add(num[i]);
			helper(result, tmp, used, num);
			tmp.remove(tmp.size() - 1);
			used[i] = false;
		}
	}
}
