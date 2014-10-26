public class Solution {
	public TreeNode sortedListToBST(ListNode head) {
		return helper(head, null);	
	}

	public TreeNode helper(ListNode head, ListNode tail) {
		if(head == tail) return null;
		ListNode mid = head;
		ListNode fast = head;
		while(fast != tail && fast.next != tail) {
			mid = mid.next;
			fast = fast.next.next;
		}
		TreeNode root = new TreeNode(mid.val);
		root.left = helper(head, mid);
		root.right = helper(mid.next, tail);
		return root;
	}
}
