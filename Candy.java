public class Solution {
	public int candy(int[] ratings) {
		if(ratings == null || ratings.length == 0)
			return 0;
		int[] numOfCandies = new int[ratings.length];
		numOfCandies[0] = 1;
		for(int i = 1; i < ratings.length; i++) {
			if(ratings[i] > ratings[i - 1])
				numOfCandies[i] = numOfCandies[i - 1] + 1;
			else
				numOfCandies[i] = 1;
		}
		for(int i = ratings.length - 2; i >= 0; i--) {
			if(ratings[i] > ratings[i + 1] && numOfCandies[i] <= numOfCandies[i + 1])
				numOfCandies[i] = numOfCandies[i + 1] + 1;
		}
		int sum = 0;
		for(int curNum : numOfCandies) {
			sum += curNum;
		}
		return sum;
	}
}
