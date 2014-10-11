public class Solution {
	public String minWindow(String S, String T) {
		if(S == null || S.length() == 0) return null;
		if(T == null || T.length() == 0) return "";

		Map<Character, Integer> expected = new HashMap<Character, Integer> ();
		Map<Character, Integer> appeared = new HashMap<Character, Integer> ();

		for(char c : T.toCharArray()) {
			Integer freq = expected.get(c);
			if(freq == null)
				freq = 0;
			expected.put(c, freq + 1);
			appeared.put(c, 0);
		}
		int start = 0;
		int total = 0;
		String minWindow = "";
		for(int i = 0; i < S.length(); i++) {
			char curChar = S.charAt(i);
			if(!expected.containsKey(curChar)) continue;
			
			appeared.put(curChar, appeared.get(curChar) + 1);
			if(appeared.get(curChar) <= expected.get(curChar))
				total ++;

			if(total == T.length()) {
				while(start < S.length()) {
					char innerChar = S.charAt(start);
					if(!expected.containsKey(innerChar)) {
						start++;
					} else if(appeared.get(innerChar) > expected.get(innerChar)){
						appeared.put(innerChar, appeared.get(innerChar) - 1);
						start++;
					} else {
						break;
					}
				}
				if(minWindow == "" || i - start + 1 < minWindow.length()) {
					minWindow = S.substring(start, i + 1);
				}
			}
		}
		return minWindow;
	}
}
