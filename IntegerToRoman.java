public class Solution{
	int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	public String intToRoman(int num) {
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] <= num)
				return romans[i] + intToRoman(num - nums[i]);
		}
		return "";
	}
}
