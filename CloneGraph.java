public class Solution {
	/*
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
	*/
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null) return null;
		return dfs(node, new HashMap<Integer, UndirectedGraphNode> ());
	}

	public UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
		UndirectedGraphNode cloned = map.get(node.label);
		if(cloned == null) {
			cloned = new UndirectedGraphNode(node.label);
			map.put(node.label, cloned);
		}
		for(UndirectedGraphNode neighbor : node.neighbors) {
			UndirectedGraphNode clonedNeighbor = map.get(neighbor.label);
			if(clonedNeighbor == null)
				clonedNeighbor = dfs(neighbor, map);
			cloned.neighbors.add(clonedNeighbor);
		}
		return cloned;
	}
}
