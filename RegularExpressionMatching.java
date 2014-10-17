public class Solution {
	public boolean isMatch(String s, String p) {
		return helper(s, p, 0, 0);
	}

	public boolean helper(String s, String p, int sPos, int pPos) {
		if(pPos == p.length()) {
			return (sPos == s.length());
		} else {
			if(pPos + 1 < p.length() && p.charAt(pPos + 1) == '*') {
				if(helper(s, p, sPos, pPos + 2)) return true;	
				int curPos = sPos;
				while(curPos < s.length() && (s.charAt(curPos) == p.charAt(pPos) || p.charAt(pPos) == '.')) {
					if(helper(s, p, curPos + 1, pPos + 2)) return true;
					curPos++;
				}
			} else if(sPos < s.length() && (s.charAt(sPos) == p.charAt(pPos) || p.charAt(pPos) == '.')){
				return helper(s, p, sPos + 1, pPos + 1);	
			}
		}
		return false;
	}

}
