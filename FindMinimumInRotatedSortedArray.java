public class Solution {
	public int findMin(int[] num) {
		if(num == null || num.length == 0)
			return Integer.MIN_VALUE;
		int start = 0;
		int end = num.length - 1;
		while(start < end) {
			int mid = start + (end - start) / 2;
			if(num[mid] < num[end])
				end = mid;
			else
				start = mid + 1;
		}
		return num[start];
	}
}
