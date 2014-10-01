public class Solution {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length < 2)
			return 0;
		
		int[] dp = new int[prices.length];
		int maxSoFar = 0;
		int minBuy = prices[0];
		for(int i = 1; i < prices.length; i++) {
			minBuy = Math.min(minBuy, prices[i]);
			maxSoFar = Math.max(maxSoFar, prices[i] - minBuy);
			dp[i] = maxSoFar;
		}
		int maxProfit = 0;
		maxSoFar = 0;
		int maxSell = prices[prices.length - 1];
		for(int i = prices.length - 2; i >= 0; i--) {
			maxSell = Math.max(maxSell, prices[i]);
			maxSoFar = Math.max(maxSoFar, maxSell - prices[i]);
			dp[i] += maxSoFar;
			maxProfit = Math.max(maxProfit, dp[i]);
		}
		return maxProfit;
	}
}
