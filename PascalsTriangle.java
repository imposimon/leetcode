public class Solution {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new LinkedList<List<Integer>> ();
		if(numRows < 1) return result;
		result.add(Arrays.asList(1));
		for(int i = 1; i < numRows; i++) {
			List<Integer> level = new LinkedList<Integer>();
			level.add(1);
			for(int j = 1; j < i; j++) {
				level.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
			}
			level.add(1);
			result.add(level);
		}
		return result;
	}
}
