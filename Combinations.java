public class Solution {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new LinkedList<List<Integer>> ();
		helper(result, new LinkedList<Integer>(), n, k, 1);
		return result;
	}

	public void helper(List<List<Integer>> result, List<Integer> tmp, int n, int k, int current) {
		if(tmp.size() == k) {
			result.add(new LinkedList<Integer>(tmp));
			return;
		}
		for(int i = current; i <= n; i++) {
			tmp.add(i);
			helper(result, tmp, n, k, i + 1);
			tmp.remove(tmp.size() - 1);
		}
	}
}
