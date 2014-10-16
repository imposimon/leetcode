public class Solution {
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> result = new LinkedList<List<Integer>> ();
		Arrays.sort(S);
		helper(result, new LinkedList<Integer>(), S, 0);
		return result;
	}
	public void helper(List<List<Integer>> result, List<Integer> tmp, int[] S, int pos) {
		result.add(new LinkedList<Integer>(tmp));
		for(int i = pos; i < S.length; i++) {
			tmp.add(S[i]);
			helper(result, tmp, S, i + 1);
			tmp.remove(tmp.size() - 1);
		}
	}	
}
