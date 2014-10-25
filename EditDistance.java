public class Solution {
	public int minDistance(String word1, String word2) {
		int len1 = (word1 == null) ? 0 : word1.length();
		int len2 = (word2 == null) ? 0 : word2.length();
		if(len1 == 0) return len2;
		if(len2 == 0) return len1;
		int[][] dp = new int[len1 + 1][len2 + 1];
		for(int i = 0; i <= len1; i++) {
			for(int j = 0; j <= len2; j++) {
				if(i == 0 && j == 0) dp[i][j] = 0;
				else if(i == 0) dp[i][j] = dp[i][j - 1] + 1;
				else if(j == 0) dp[i][j] = dp[i - 1][j] + 1;
				else {
					int min1 = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
					int min2 = (word1.charAt(i - 1) == word2.charAt(j - 1)) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
					dp[i][j] = Math.min(min1, min2);
				}
			}
		}
		return dp[len1][len2];
	}
}
