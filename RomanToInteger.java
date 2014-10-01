public class Solution {
	public int romanToInt(String s) {
		if(s == null || s.length() == 0)
			return 0;
		int result = charToNum(s.charAt(s.length() - 1));
		for(int i = s.length() - 2; i >= 0; i--) {
			int cur = charToNum(s.charAt(i + 1));
			int prev = charToNum(s.charAt(i));
			if(prev < cur)
				result -= prev;
			else
				result += prev;
		}
		return result;
	}

	public int charToNum(char c) {
		int num = 0;
		switch(c) {
			case 'M': num = 1000; break;
			case 'D': num = 500; break;
			case 'C': num = 100; break;
			case 'L': num = 50; break;
			case 'X': num = 10; break;
			case 'V': num = 5; break;
			case 'I': num = 1; break;
		}
		return num;
	}
}
