public class Solution {
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new LinkedList<String> ();
		helper(result, new int[4], 0, s, 0);
		return result;
	}

	public void helper(List<String> result, int[] tmp, int tPos, String s, int sPos) {
		if(tPos == 4) {
			if(sPos == s.length())
				result.add(generateResult(tmp));
			return;
		}
		int end = Math.min(s.length(), sPos + 3);
		for(int i = sPos + 1; i <= end; i++) {
			String digits = s.substring(sPos, i);
			if(digits.equals("0")) {
				tmp[tPos] = 0;
				helper(result, tmp, tPos + 1, s, i);
				break;
			}
			else {
				int cur = Integer.parseInt(digits);
				if(cur >= 0 && cur <= 255) {
				tmp[tPos] = cur;
				helper(result, tmp, tPos + 1, s, i);
			}
		}
	}

	public String generateResult(int[] segs) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 4; i++) {
			if(i != 0)
				sb.append('.');
			sb.append(segs[i]);
		}
		return sb.toString();
	}
}
