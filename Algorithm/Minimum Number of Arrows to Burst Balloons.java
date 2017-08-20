public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b)->(a[1] - b[1]));
        int rst = 0;
        long end = Long.MIN_VALUE;
        for (int[] p : points) {
            if (end < p[0]) {
                rst++;
                end = p[1];
            }
        }
        return rst;
    }
}