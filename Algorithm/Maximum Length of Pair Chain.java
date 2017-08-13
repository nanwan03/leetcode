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
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < pairs.length; ++i) {
            if (end < pairs[i][0]) {
                rst++;
                end = pairs[i][1];
            }
        }
        return rst;
    }
}