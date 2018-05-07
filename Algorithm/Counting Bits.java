class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        if (num == 0) {
            return dp;
        }
        int leftOne = 1;
        for (int i = 1; i <= num; ++i) {
            if ((i >>> 1) == leftOne) {
                leftOne = leftOne << 1;
            }
            dp[i] = 1 + dp[i - leftOne];
        }
        return dp;
    }
}