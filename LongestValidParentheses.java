public class Solution {
	public int longestValidParentheses(String s) {
		if(s == null || s.length() < 2) return 0;
		int n = s.length();
		int[] dp = new int[n];
		dp[0] = 0;
		int max = 0;
		for(int i = 1; i < n; i++) {
			char cur = s.charAt(i);
			if(cur == '(') {
				dp[i] = 0;	
			} else if(cur == ')') {
				int matchedIndex = i - dp[i - 1] - 1;	
				if(matchedIndex >= 0 && s.charAt(matchedIndex) == '(') {
					dp[i] = dp[i - 1] + 2;
					if(matchedIndex - 1 >= 0)
						dp[i] += dp[matchedIndex - 1];
				} else {
					dp[i] = 0;
				}
				max = Math.max(max, dp[i]);
			}
		}
		return max;	
	}
}
