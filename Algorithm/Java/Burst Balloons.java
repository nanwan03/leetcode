class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = nums.length;
        int[] helper = new int[size + 2];
        helper[0] = 1;
        helper[helper.length - 1] = 1;
        for (int i = 0; i < nums.length; ++i) {
            helper[i + 1] = nums[i];
        }
        size += 2;
        int[][] dp = new int[size][size];
        for (int end = 1; end <= size - 2; ++end) {
            for (int start = end; start >= 1; --start) {
                for (int k = end; k >= start; --k) {
                    dp[start][end] = Math.max(dp[start][end], dp[start][k - 1] + dp[k + 1][end] + helper[start - 1] * helper[k] * helper[end + 1]);
                }
            }
        }
        return dp[1][size - 2];
    }
}