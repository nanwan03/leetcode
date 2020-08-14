public class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int size = s.length();
        int[][] dp = new int[size][size];
        for (int end = 0; end < size; ++end) {
            dp[end][end] = 1;
            for (int start = end - 1; start >= 0; --start) {
                if (s.charAt(start) == s.charAt(end)) {
                    dp[start][end] = dp[start + 1][end - 1] + 2;
                } else {
                    dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                }
            }
        }
        return dp[0][size - 1];
    }
}