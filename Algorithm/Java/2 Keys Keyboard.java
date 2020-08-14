class Solution {
    public int minSteps(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            dp[i] = i;
            for (int j = i / 2; j > 1; --j) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i / j);
                    break;
                }
            }
        }
        return dp[n];
    }
}