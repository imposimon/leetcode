public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null) return null;
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode> ();
		Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode> ();
		UndirectedGraphNode cloned = new UndirecredGraphNode(node.label);
		map.put(node.label, cloned);
		queue.add(node);
		while(!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.remove();
			UndirectedGraphNode curCloned = map.get(cur.label);
			for(UndirectedGraphNode neighbor : cur.neighbors) {
				UndirectedGraphNode clonedNeighbor = map.get(neighbor.label);	
				if(clonedNeighbor == null) {
					clonedNeighbor = new UndirectedGraphNode(neighbor.label);
					map.put(neighbor.label, clonedNeighbor);
					queue.add(neighbor);
				}
				curCloned.neighbors.add(clonedNeighbor);
			}
		}
		return cloned;
	}
}
