public class Solution {
	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists == null || lists.size() == 0) return null;
		int k = lists.size();
		MinHeap<ListNode> heap = new MinHeap<ListNode>(k, new ListNodeComparator());
		for(ListNode list : lists) {
			if(list != null)
				heap.add(list);
		}
		ListNode dummyHead = new ListNode(0);
		ListNode cur = dummyHead;
		while(!heap.isEmpty()) {
			ListNode min = heap.remove();
			cur.next = min;
			cur = cur.next;
			if(min.next != null)
				heap.add(min.next);
		}
		return dummyHead.next;
	}

	class ListNodeComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode l1, ListNode l2) {
			return l1.val - l2.val;
		}
	}

	class MinHeap<K> {
		K[] array;
		Comparator<K> comparator;
		int next;
		public MinHeap(int size, Comparator<K> c) {
			this.array = (K[])new Object[size];	
			this.comparator = c;
			this.next = 0;
		}

		public K remove() {
			if(isEmpty()) return null;
			K min = array[0];
			array[0] = array[next - 1];
			next --;
			shiftDown(0);
			return min;
		}

		public void add(K k) {
			if(next == array.length) return;
			array[next] = k;
			shiftUp(next);
			next ++;
		}

		public boolean isEmpty() {
			return (next == 0);
		}

		private void shiftDown(int i) {
			int l = getLeftChild(i);
			int r = getRightChild(i);
			if(r < next) {
				int min = l;
				if(comparator.compare(array[l], array[r]) > 0) {
					min = r;
				}
				if(comparator.compare(array[i], array[min]) > 0) {
					swap(i, min);
					shiftDown(min);
				}
			} else if(l < next) {
				if(comparator.compare(array[i], array[l]) > 0) {
					swap(i, l);
					shiftDown(l);
				}
			}
		}

		private void shiftUp(int i) {
			int parent = getParent(i);
			if(parent >= 0 && comparator.compare(array[parent], array[i]) > 0) {
				swap(i, parent);
				shiftUp(parent);
			}
		}

		private void swap(int i, int j) {
			K tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
		}

		private int getParent(int i) {
			return (i - 1) / 2;
		}

		private int getLeftChild(int i) {
			return i * 2 + 1;
		}

		private int getRightChild(int i) {
			return i * 2 + 2;
		}
	}
}
