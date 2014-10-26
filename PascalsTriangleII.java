public class Solution {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new LinkedList<Integer> ();
		result.add(1);
		for(int i = 1; i <= rowIndex; i++) {
			List<Integer> tmp = new LinkedList<Integer> ();	
			tmp.add(1);
			for(int j = 1; j < i; j++) {
				tmp.add(result.get(j) + result.get(j - 1));
			}
			tmp.add(1);
			result = tmp;
		}
		return result;
	}
}
