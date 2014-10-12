public class Solution {
	public String longestPalindrome(String s) {
		if(s == null || s.length() < 2) return s;
		int maxLength = 0;
		String longest = "";
		for(int i = 0; i < s.length(); i++) {
			int start = i;
			int end = i;
			while(end < s.length() - 1 && s.charAt(end + 1) == s.charAt(end)) {
				end++;
			}
			while(start > 0 && end < s.length() - 1 && s.charAt(start - 1) == s.charAt(end + 1)) {
				start--;
				end++;
			}
			if(end - start + 1 > maxLength) {
				longest = s.substring(start, end + 1);
				maxLength = end - start + 1;
			}
		}
		return longest;
	}
}
