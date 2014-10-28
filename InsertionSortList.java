public class Solution {
	public ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		dummyHead.next = head;
		ListNode prev = head;
		while(prev != null && prev.next != null) {
			ListNode cur = prev.next;
			if(cur.val >= prev.val) {
				prev = cur;
			} else {
				ListNode pos = dummyHead;

				while(pos.next != prev && pos.next.val < cur.val) {
					pos = pos.next;
				}
				
				prev.next = cur.next;
				cur.next = pos.next;
				pos.next = cur;
			}
		}
		return dummyHead.next;
	}

}
