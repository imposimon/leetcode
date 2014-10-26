public class Solution {
	public ListNode partition(ListNode head, int x) {
		if(head == null) return head;

		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode dummyHead2 = new ListNode(0);
		ListNode p = dummyHead;
		ListNode q = dummyHead2;
		while(p != null && p.next != null) {
			ListNode cur = p.next;
			if(cur.val < x) p = cur;
			else {
				p.next = cur.next;
				q.next = cur;
				cur.next = null;
				q = cur;
			}
		}
		p.next = dummyHead2.next;
		return dummyHead.next;
	}
}
