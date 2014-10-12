public class Solution {
	public boolean isNumber(String s) {
		if(s == null) return false;
		s = s.trim();
		if(s.length() == 0) return false;
		int i = 0;
		boolean num = false;
		boolean exp = false;
		boolean dot = false;
		if(s.startsWith("+") || s.startsWith("-")) i++;
		while(i < s.length()) {
			char curChar = s.charAt(i);
			if(Character.isDigit(curChar)) {
				num = true;
			}
			else if(curChar == '.') {
				if(exp || dot) return false;
				dot = true;
			} else if(curChar == 'e') {
				if(exp || !num) return false;
				exp = true;
				num = false;
			} else if(curChar == '+' || curChar == '-') {
				if(s.charAt(i - 1) != 'e') return false;
			} else {
				return false;
			}
			i++;
		}
		return num;
		
	}
}
