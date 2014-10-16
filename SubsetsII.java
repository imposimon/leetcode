public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> result = new LinkedList<List<Integer>> ();
		Arrays.sort(num);
		helper(result, new LinkedList<Integer>(), num, 0);
		return result;
	}

	public void helper(List<List<Integer>> result, List<Integer> tmp, int[] num, int pos) {
		result.add(new LinkedList<Integer>(tmp));
		for(int i = pos; i < num.length; i++) {
			if(i != pos && num[i] == num[i - 1]) continue;
			tmp.add(num[i]);
			helper(result, tmp, num, i + 1);
			tmp.remove(tmp.size() - 1);
		}
	}
}
