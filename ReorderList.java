public class Solution {
	public void reorderList(ListNode head) {
		if(head == null || head.next == null) return;
		ListNode mid = split(head);
		mid = reverse(mid);
		reconnect(head, mid);
	}

	public ListNode split(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode mid = slow.next;	
		slow.next = null;
		return mid;
	}

	public ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;
		while(cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	public void reconnect(ListNode l1, ListNode l2) {
		while(l1 != null && l1.next != null && l2 != null) {
			ListNode next = l1.next;
			l1.next = l2;
			l2 = l2.next;
			l1.next.next = next;
			l1 = next;
		}
		if(l1.next == null && l2 != null)
			l1.next = l2;
	}

	
}
