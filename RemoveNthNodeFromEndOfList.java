public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || n < 1) return head;
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode prev = dummyHead;
		ListNode cur = head;
		for(int i = 0; i < n && cur != null; i++) {
			cur = cur.next;
		}
		while(cur != null) {
			prev = prev.next;
			cur = cur.next;
		}
		prev.next = prev.next.next;
		return dummyHead.next;
	}
}
