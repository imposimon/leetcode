public class Solution {
	/*
	public int longestConsecutive(int[] num) {
		if(num == null || num.length == 0) return 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 1;
		for(int i : num) {
			if(!map.containsKey(i)) {
				map.put(i, 1);
				if(map.containsKey(i - 1))
					max = Math.max(max, merge(map, i - 1, i));
				if(map.containsKey(i + 1))
					max = Math.max(max, merge(map, i, i + 1));
			}
		}
		return max;
	}

	private int merge(Map<Integer, Integer> map, int left, int right) {
		int lower = left - map.get(left) + 1;
		int upper = right + map.get(right) - 1;
		int length = upper - lower + 1;
		map.put(lower, length);
		map.put(upper, length);
		return length;
	}
	*/

	public int longestConsecutive(int[] num) {
		if(num == null || num.length == 0) return 0;
		Set<Integer> set = new HashSet<Integer> ();
		for(int n : num) {
			set.add(n);
		}
		int max = 1;
		for(int n : num) {
			if(set.contains(n)) {
				set.remove(n);
				int length = 1;
				int prev = n - 1;
				while(set.contains(prev)) {
					set.remove(prev);
					prev--;
					length++;
				}
				int next = n + 1;
				while(set.contains(next)) {
					set.remove(next);
					next++;
					length++;
				}
				max = Math.max(max, length);
			}
		}
		return max;
	}
}
