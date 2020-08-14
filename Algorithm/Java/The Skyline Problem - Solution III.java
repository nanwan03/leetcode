public class Solution {
    private class Endpoint {
		int height;
		boolean isStart;
		public Endpoint(int height, boolean isStart) {
			this.height = height;
			this.isStart = isStart;
		}
	}
    public List<int[]> getSkyline(int[][] buildings) {
        // write your code here
    	List<int[]> rst = new ArrayList<int[]>();
    	if (buildings == null || buildings.length == 0) {
    		return rst;
    	}
    	TreeMap<Integer, List<Endpoint>> pointToHeight = new TreeMap<Integer, List<Endpoint>>();
    	TreeMap<Integer, Integer> bst = new TreeMap<Integer, Integer>();
    	int curMax = 0;
    	for (int[] build : buildings) {
    		int start = build[0];
    		int end = build[1];
    		int height = build[2];
    		if (!pointToHeight.containsKey(start)) {
    			pointToHeight.put(start, new ArrayList<Endpoint>());
    		}
    		pointToHeight.get(start).add(new Endpoint(height, true));
    		
    		if (!pointToHeight.containsKey(end)) {
    			pointToHeight.put(end, new ArrayList<Endpoint>());
    		}
    		pointToHeight.get(end).add(new Endpoint(height, false));
    	}
    	Iterator<Map.Entry<Integer, List<Endpoint>>> it = pointToHeight.entrySet().iterator();
    	while (it.hasNext()) {
    		Map.Entry<Integer, List<Endpoint>> entry = it.next();
    		int point = entry.getKey();
    		List<Endpoint> heights = entry.getValue();
    		for (Endpoint height : heights) {
    			if (height.isStart) {
    				if (!bst.containsKey(height.height)) {
    					bst.put(height.height, 1);
    				} else {
    					bst.put(height.height, bst.get(height.height) + 1);
    				}
    			} else {
    				if (bst.get(height.height) == 1) {
    					bst.remove(height.height);
    				} else {
    					bst.put(height.height, bst.get(height.height) - 1);
    				}
    			}
    		}
    		if (bst.isEmpty() || curMax != bst.lastKey()) {
    			curMax = bst.isEmpty() ? 0 : bst.lastKey();
    			rst.add(new int[]{point, curMax});
    		}
    	}
    	return rst;
    }
}