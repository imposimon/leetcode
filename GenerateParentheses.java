public class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> result = new LinkedList<String> ();
		helper(result, new StringBuilder(), 0, 0, n);
		return result;
	}

	public void helper(List<String> result, StringBuilder sb, int l, int r, int n) {
		if(l == n && r == n) {
			result.add(sb.toString());
			return;
		}

		if(l > n || r > n) return;

		sb.append('(');
		helper(result, sb, l + 1, r, n);
		sb.deleteCharAt(sb.length() - 1);
		if(l > r) {
			sb.append(')');
			helper(result, sb, l, r + 1, n);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
