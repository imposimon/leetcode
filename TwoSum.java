public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		int[] indices = null;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < numbers.length; i++) {
			Integer j = map.get(numbers[i]);
			if(j != null) {
				indices = new int[]{j + 1, i + 1}; 
				break;
			}
			map.put(target - numbers[i], i);
		}
		return indices;
	}
}
