public class Solution {
	public List<String> fullJustify(String[] words, int L) {
		List<String> result = new LinkedList<String> ();
		if(words == null || words.length == 0)
			return result;
		Queue<String> queue = new LinkedList<String> ();
		int curLen = 0;
		for(int i = 0; i < words.length; i++) {
			if(curLen + queue.size() + words[i].length() > L) {
				int numSlot = queue.size() - 1;
				if(numSlot == 0) {
					StringBuilder sb = new StringBuilder(queue.remove());
					while(sb.length() < L) {
						sb.append(' ');
					}
					result.add(sb.toString());
				} else {
					int totalSpace = L - curLen;
					int numSpace = totalSpace / numSlot;	
					int numLeftSlot = totalSpace % numSlot;
					StringBuilder sb = new StringBuilder();
					for(int j = 0; j < numSlot; j++) {
						sb.append(queue.remove());
						for(int k = 0; k < numSpace; k++) {
							sb.append(' ');
						}
						if(j < numLeftSlot)
							sb.append(' ');
					}
					sb.append(queue.remove());
					result.add(sb.toString());
				}
				curLen = 0;
			}
			queue.add(words[i]);
			curLen += words[i].length();
		}
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			if(sb.length() != 0)
				sb.append(' ');
			sb.append(queue.remove());
		}
		while(sb.length() < L) {
			sb.append(' ');
		}
		result.add(sb.toString());
		return result;
	}
}
