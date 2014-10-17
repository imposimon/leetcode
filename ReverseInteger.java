public class Solution {
	public int reverse(int x) {
		boolean isNegative = (x < 0) ? true : false;
		if(isNegative) 
			x = -x;
		int result = 0;
		while(x > 0) {
			int curDigit = x % 10;
			result = result * 10 + curDigit;
			x = x / 10;
		}
		return (isNegative) ? -result : result;
	}
}
