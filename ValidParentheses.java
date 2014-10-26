public class Solution {
	public boolean isValid(String s) {
		if(s == null || s.length() == 0) return true;
		Stack<Character> stack = new Stack<Character> ();
		for(char c : s.toCharArray()) {
			if(c == '(' || c == '[' || c == '{')
				stack.push(c);
			else if(c == ')' || c == ']' || c == '}') {
				if(stack.isEmpty()) return false;
				char prev = stack.pop();
				if(!matches(prev, c)) return false;
			}
		}
		return stack.isEmpty();
	}

	public boolean matches(char l, char r) {
		if(l == '(') return r == ')';
		else if(l == '[') return r == ']';
		else if(l == '{') return r == '}';
		else return false;
	}
}
