public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(points.length==0 || points[0].length==0) {
            return 0;
        }
        int rst = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int[] p = points[i];
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int[] q = points[j];
                int dis = getDis(p, q);
                if(!map.containsKey(dis)) {
                    map.put(dis, 0);
                }
                map.put(dis, map.get(dis) + 1);
            }
            for(int size : map.values()) {
                rst += (size * (size - 1));
            }
        }
        return rst;
    }
    private int getDis(int[] p, int[] q) {
        int dx = p[0] - q[0];
        int dy = p[1] - q[1];
        return dx*dx + dy*dy;
    }
}