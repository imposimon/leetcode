public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
			return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int dp[][] = new int[m][n];
		if(obstacleGrid[m - 1][n - 1] == 1)
			return 0;
		dp[m - 1][n - 1] = 1;
		for(int i = m - 2; i >= 0; i--) {
			dp[i][n - 1] = (obstacleGrid[i][n - 1] == 1) ? 0 : dp[i + 1][n - 1];
		}	
		for(int j = n - 2; j >= 0; j--) {
			dp[m - 1][j] = (obstacleGrid[m - 1][j] == 1) ? 0 : dp[m - 1][j + 1];
		}

		for(int i = m - 2; i >= 0; i--) {
			for(int j = n - 2; j >= 0; j--) {
				dp[i][j] = (obstacleGrid[i][j] == 1) ? 0 : dp[i + 1][j] + dp[i][j + 1];
			}
		}
		return dp[0][0];
	}
}

