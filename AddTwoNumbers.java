public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;

		ListNode dummyHead = new ListNode(0);
		ListNode p = dummyHead;
		int carry = 0;
		while(l1 != null && l2 != null) {
			int curSum = l1.val + l2.val + carry;
			carry = curSum / 10;
			p.next = new ListNode(curSum % 10);
			p = p.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		ListNode rest = (l1 == null) ? l2 : l1;
		while(rest != null) {
			int curSum = rest.val + carry;
			carry = curSum / 10;
			p.next = new ListNode(curSum % 10);
			p = p.next;
			rest = rest.next;
		}
		if(carry != 0) {
			p.next = new ListNode(carry);
		}
		return dummyHead.next;
	}
}
