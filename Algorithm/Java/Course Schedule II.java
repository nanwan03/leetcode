public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] a = prerequisites;
        int[] rst = new int[numCourses];
        int index = 0;
        if (numCourses == 1) {
            return rst;
        }
        if (numCourses == 0 || a == null || a.length == 0) {
            for (int i = 0; i < numCourses; ++i) {
                rst[i] = i;
            }
            return rst;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numCourses; ++i) {
            map.put(i, 0);
        }
        for (int[] dep : a) {
            map.put(dep[0], map.get(dep[0]) + 1);
        }
        while (map.size() != 0) {
            Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
            int size = map.size();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> entry = it.next();
                if (entry.getValue() == 0) {
                    int key = entry.getKey();
                    rst[index++] = key;
                    for (int[] dep : a) {
                        if (dep[1] == key) {
                            map.put(dep[0], map.get(dep[0]) - 1);
                        }
                    }
                    it.remove();
                }
            }
            if (size == map.size()) {
                int[] emptyArray = {};
                return emptyArray;
            }
        }
        return rst;
    }
}