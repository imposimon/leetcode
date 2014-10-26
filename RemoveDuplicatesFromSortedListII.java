public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return head;
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode p = dummyHead;
		while(p != null && p.next != null) {
			ListNode next = p.next.next;
			while(next != null && next.val == p.next.val) {
				next = next.next;
			}
			if(next != p.next.next)
				p.next = next;
			else
				p = p.next;
		}
		return dummyHead.next;
	}
}
