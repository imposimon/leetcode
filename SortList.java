public class Solution {
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode mid = split(head);
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(mid);
		return merge(l1, l2);
	}

	public ListNode split(ListNode head) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode fast = dummyHead;
		ListNode slow = dummyHead;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode mid = slow.next;
		slow.next = null;
		return mid;
	}

	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode cur = dummyHead;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if(l1 != null) cur.next = l1;
		if(l2 != null) cur.next = l2;
		return dummyHead.next;
	}

}
