public class Solution {
	char[][] mappings = {{' '},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
							{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

	public List<String> letterCombinations(String digits) {
		List<String> result = new LinkedList<String> ();
		result.add("");
		if(digits == null || digits.length() == 0)
			return result;
		for(char digit : digits.toCharArray()) {
			char[] chars = mappings[digit - '0'];
			List<String> newResult = new LinkedList<String> ();
			for(String s : result) {
				for(char c : chars) {
					newResult.add(s + c);
				}
			}
			result = newResult;
		}
		return result;
	}

	//Recursive
	/*
	public List<String> letterCombinations(String digits) {
		List<String> result = new LinkedList<String> ();
		helper(result, new StringBuilder(), digits, 0);
		return result;
	}

	public void helper(List<String> result, StringBuilder sb, String digits, int pos) {
		if(pos == digits.length()) {
			result.add(sb.toString());
			return;
		}
		for(char c : mappings[digits.charAt(pos) - '0']) {
			sb.append(c);
			helper(result, sb, digits, pos + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	*/
}
