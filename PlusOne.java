public class Solution {
	public int[] plusOne(int[] digits) {
		if(digits == null || digits.length == 0) return digits;
		int carry = 1;
		for(int i = digits.length - 1; i >= 0; i--) {
			int curSum = digits[i] + carry;
			digits[i] = curSum % 10;
			carry = curSum / 10;
		}
		int[] result = digits;
		if(carry == 1) {
			result = new int[digits.length + 1];
			result[0] = carry;
			for(int i = 0; i < digits.length; i++) {
				result[i + 1] = digits[i];
			}
		}
		return result;
	}
}
