public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null) return null;
		RandomListNode p = head;
		while(p != null) {
			RandomListNode newNode = new RandomListNode(p.label);
			newNode.next = p.next;
			p.next = newNode;
			p = newNode.next;
		}
		p = head;
		while(p != null) {
			p.next.random = (p.random == null) ? null : p.random.next;
			p = p.next.next;
		}
		RandomListNode cloned = head.next;
		p = head;
		RandomListNode q = cloned;
		while(p != null) {
			p.next = q.next;
			p = p.next;	
			if(p != null) {
				q.next = p.next;
				q = q.next;
			}
		}
		return cloned;
	}
}
