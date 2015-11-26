public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> rst = new ArrayList<Integer>();
        if (n == 1) {
    		rst.add(0);
    		return rst;
    	}
        Set<Integer> removedEdge = new HashSet<Integer>();
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < edges.length; ++i) {
        	int n1 = edges[i][0];
        	int n2 = edges[i][1];
        	if (!map.containsKey(n1)) {
        		map.put(n1,  new HashSet<Integer>());
        	}
        	map.get(n1).add(n2);
        	if (!map.containsKey(n2)) {
        		map.put(n2,  new HashSet<Integer>());
        	}
        	map.get(n2).add(n1);
        }
        while (map.size() != 0) {
        	rst.clear();
        	removedEdge.clear();
        	Iterator<Map.Entry<Integer, Set<Integer>>> it = map.entrySet().iterator();
        	while (it.hasNext()) {
        		Map.Entry<Integer, Set<Integer>> entry = it.next();
        		if (entry.getValue().size() == 0) {
        			rst.add(entry.getKey());
        			it.remove();
        		} else if (entry.getValue().size() == 1) {
        			removedEdge.add(entry.getKey());
        			rst.add(entry.getKey());
        			it.remove();
        		}
        	}
        	it = map.entrySet().iterator();
        	while (it.hasNext()) {
        		Map.Entry<Integer, Set<Integer>> entry = it.next();
        		entry.getValue().removeAll(removedEdge);
        	}
        }
        Collections.sort(rst);
        return rst;
    }
}