public class Solution {
    private class Cmp implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, new Cmp());
        int rst = 0;
        int n = pairs.length;
        for (int i = 0; i < n; ++i) {
            rst++;
            int end = pairs[i][1];
            while (i + 1 < n && pairs[i + 1][0] <= end) {
                i++;
            }
        }
        return rst;
    }
}