public class Solution {
	public String addBinary(String a, String b) {
		if(a == null || a.length() == 0) return b;
		if(b == null || b.length() == 0) return a;

		String longer = (a.length() > b.length()) ? a : b;
		String shorter = (a.length() > b.length()) ? b : a;
		char[] result = new char[longer.length()];
		int carry = 0;
		int i = longer.length() - 1;
		int j = shorter.length() - 1;
		int k = result.length - 1;
		while(i >= 0 && j >= 0) {
			int curSum = longer.charAt(i) - '0' + shorter.charAt(j) - '0' + carry;
			carry = curSum / 2;
			result[k] = (char) (curSum % 2 + '0');
			i--;
			j--;
			k--;
		}
		while(i >= 0) {
			int curSum = longer.charAt(i) - '0' + carry;
			carry = curSum / 2;
			result[k] = (char) (curSum % 2 + '0');
			i--;
			k--;
		}
		String resultString = new String(result);
		if(carry == 1)
			resultString = "1" + resultString;
		return resultString;
	}
}
