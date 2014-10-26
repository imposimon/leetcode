public class Solution {
	public ListNode swapPairs(ListNode head) {
		if(head == null) return null;

		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		
		ListNode prev = dummyHead;
		while(prev != null && prev.next != null) {
			ListNode cur = prev.next;
			ListNode next = cur.next;
			if(next != null) {
				prev.next = next;
				cur.next = next.next;
				next.next = cur;
			}
			prev = cur;
		}
		return dummyHead.next;
	}
}
