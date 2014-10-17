public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Arrays.sort(candidates);
		helper(result, new LinkedList<Integer> (), candidates, 0, target);
		return result;
	}

	public void helper(List<List<Integer>> result, List<Integer> tmp, int[] candidates, int pos, int target) {
		if(target == 0) {
			result.add(new LinkedList<Integer>(tmp));
			return;
		}
		for(int i = pos; i < candidates.length; i++) {
			if(candidates[i] > target) break;
			tmp.add(candidates[i]);
			helper(result, tmp, candidates, i, target - candidates[i]);
			tmp.remove(tmp.size() - 1);
		}

	}
	/*
	public void helper(List<List<Integer>> result, List<Integer> tmp, int[] candidates, int pos, int target) {
		if(target == 0) {
			result.add(new LinkedList<Integer>(tmp));
			return;
		}
		if(pos >= candidates.length || candidates[pos] > target)
			return;
		tmp.add(candidates[pos]);
		helper(result, tmp, candidates, pos, target - candidates[pos]);
		tmp.remove(tmp.size() - 1);
		helper(result, tmp, candidates, pos + 1, target);
	}
	*/
}
