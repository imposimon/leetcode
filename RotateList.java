public class Solution {
	public ListNode rotateRight(ListNode head, int n) {
		if(head == null || head.next == null) return head;
		int length = 0;
		ListNode p = head;
		while(p != null) {
			length++;
			p = p.next;
		}
		n = n % length;

		ListNode prev = head;
		ListNode tail = head;
		for(int i = 0; i < n; i++) {
			tail = tail.next;
		}
		while(tail.next != null) {
			tail = tail.next;
			prev = prev.next;
		}
		tail.next = head;
		head = prev.next;
		prev.next = null;
		return head;
	}
}
