public class Solution {
	public int evalRPN(String[] tokens) {
		if(tokens == null || tokens.length == 0) return 0;
		Stack<Integer> stack = new Stack<Integer> ();
		for(String token : tokens) {
			if(isOperator(token)) {
				int num2 = stack.pop();
				int num1 = stack.pop();
				int result = calculate(num1, num2, token);
				stack.push(result);
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}

	public boolean isOperator(String token) {
		return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");	
	}

	public int calculate(int num1, int num2, String token) {
		if(token.equals("+"))
			return num1 + num2;
		else if(token.equals("-"))
			return num1 - num2;
		else if(token.equals("*"))
			return num1 * num2;
		else
			return num1 / num2;
	}
}
