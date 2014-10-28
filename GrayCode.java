public class Solution {
	public List<Integer> grayCode(int n) {
		List<Integer> result = new LinkedList<Integer>();
		if(n < 0) return result;
		result.add(0);
		for(int i = 0; i < n; i++) {
			for(int j = result.size() - 1; j >= 0; j--) {
				int cur = result.get(j);
				result.add(cur + (1 << i));
			}
		}
		return result;
	}
}
