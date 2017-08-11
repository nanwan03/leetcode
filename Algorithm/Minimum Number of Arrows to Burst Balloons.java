public class Solution {
    private class Cmp implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Cmp());
        int target = points[0][1];
        int rst = 1;
        for (int i = 1; i < points.length; i++) {
            if (target >= points[i][0]) {
                continue;
            }
            rst++;
            target = points[i][1];
        }
        return rst;
    }
}