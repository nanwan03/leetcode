public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] a = prerequisites;
        if (numCourses == 1) {
            return new int[]{0};
        }
        if (numCourses == 0 || a == null || a.length == 0) {
            int[] rst = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                rst[i] = i;
            }
            return rst;
        }
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < a.length; i++) {
            int prev = a[i][1];
            int cur = a[i][0];
            graph.get(prev).add(cur);
        }
        return toplogicalSort(graph);
    }
    private int[] toplogicalSort(List<List<Integer>> graph) {
        int[] rst = new int[graph.size()];
        int index = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < graph.size(); i++) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }
            List<Integer> list = graph.get(i);
            for (int j : list) {
                if (!map.containsKey(j)) {
                    map.put(j, 1);
                } else {
                    map.put(j, map.get(j) + 1);
                }
            }
        }
        while (map.size() != 0) {
            Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
            int beforeSize = map.size();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> entry = it.next();
                if (entry.getValue() == 0) {
                    int key = entry.getKey();
                    for (int neighbor : graph.get(key)) {
                        map.put(neighbor, map.get(neighbor) - 1);
                    }
                    rst[index++] = key;
                    it.remove();
                }
            }
            if (map.size() == beforeSize) {
                return new int[0];
            }
        }
        return rst;
    }
}