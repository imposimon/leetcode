public class Solution {
	public int numDecodings(String s) {
		if(s == null || s.length() == 0) return 0;
		int[] dp = new int[s.length() + 1];
		dp[s.length()] = 1;
		for(int i = s.length() - 1; i >= 0; i--) {
			dp[i] = (between1and9(s, i)) ? dp[i + 1] : 0;
			dp[i] += (between10and26(s, i)) ? dp[i + 2] : 0;
		}
		return dp[0];
	}

	public boolean between1and9(String s, int i) {
		if(s == null || i >= s.length()) return false;
		char c = s.charAt(i);
		return (c >= '1' && c <= '9');
	}

	public boolean between10and26(String s, int i) {
		if(s == null || i >= s.length() - 1) return false;
		char c1 = s.charAt(i);
		char c2 = s.charAt(i + 1);
		if(c1 == '1' && c2 >= '0' && c2 <= '9') return true;
		else if(c1 == '2' && c2 >='0' && c2 <= '6') return true;
		else return false;
	}
}
