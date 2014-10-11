public class Solution {
	public String multiply(String num1, String num2) {
		if(num1 == null || num2 == null ||
			num1.length() == 0 || num2.length() == 0 ||
			num1.equals("0") || num2.equals("0"))
			return "0";

		int[] result = new int[num1.length() + num2.length()];
		for(int i = num1.length() - 1; i >= 0; i--) {
			int carry = 0;
			for(int j = num2.length() - 1; j >= 0; j--) {
				int tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry + result[i + j + 1];	
				carry = tmp / 10;
				result[i + j + 1] = tmp % 10;
			}
			result[i] = carry;
		}
		int pos = 0;
		while(pos < result.length && result[pos] == 0) {
			pos ++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = pos; i < result.length; i++) {
			sb.append(result[i]);
		}
		return sb.toString();
	}
}
