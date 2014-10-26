public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return head;
		ListNode cur = head;
		while(cur != null && cur.next != null) {
			ListNode next = cur.next;
			if(cur.val == next.val)
				cur.next = next.next;
			else
				cur = next;
		}
		return head;
	}
}
