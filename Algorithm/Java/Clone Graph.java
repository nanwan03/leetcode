/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
        	return node;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        map.put(node, new UndirectedGraphNode(node.label));
        queue.offer(node);
        while (!queue.isEmpty()) {
        	UndirectedGraphNode oldNode = queue.poll();
        	UndirectedGraphNode newNode = map.get(oldNode);
        	for (UndirectedGraphNode neighbor : oldNode.neighbors) {
        		if (!map.containsKey(neighbor)) {
        			queue.offer(neighbor);
        			map.put(neighbor, new UndirectedGraphNode(neighbor.label));
        		}
        		newNode.neighbors.add(map.get(neighbor));
        	}
        }
        return map.get(node);
    }
}