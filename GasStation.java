public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas == null || cost == null ||
		gas.length == 0 || cost.length == 0 ||
		gas.length != cost.length)
			return -1;

		int length = gas.length;
		int gasRemain = gas[0] - cost[0];
		int start = 0;
		int end = 0;
		while((end + 1) % length != start) {
			if(gasRemain < 0) {
				start = (start + length - 1) % length;
				gasRemain += gas[start] - cost[start];
			} else {
				end = (end + 1) % length;
				gasRemain += gas[end] - cost[end];
			}
		}

		if(gasRemain >= 0)
			return start;
		else	
			return -1;
	}
}
