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
        int end = Integer.MIN_VALUE;
        int rst = 0;
        for (int[] pair : pairs) {
            if (end < pair[0]) {
                end = pair[1];
                rst++;
            }
        }
        return rst;
    }
}