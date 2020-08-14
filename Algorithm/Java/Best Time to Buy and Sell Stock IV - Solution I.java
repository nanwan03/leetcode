class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int size = prices.length;
        if (k >= size / 2) {
            int rst = 0;
            int min = prices[0];
            for (int i = 1; i < prices.length; ++i) {
                rst += Math.max(0, prices[i] - prices[i - 1]);
            }
            return rst;
        }
        int[][] dp = new int[k + 1][size];
        for (int i = 1; i <= k; ++i) {
            int localMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < size; ++j) {
                dp[i][j] = Math.max(dp[i][j - 1], localMax + prices[j]);
                localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][size - 1];
    }
}