public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int[] dp = new int[s.length()];
        for (int end = 0; end < s.length(); end++) {
            dp[end] = end;
            for (int start = end; start >= 0; start--) {
                if (s.charAt(start) == s.charAt(end) &&
                    (end - start < 2 || isPalindrome[start + 1][end - 1])) {
                    isPalindrome[start][end] = true;
                    if (start == 0) {
                        dp[end] = 0;
                    } else {
                        dp[end] = Math.min(dp[end], dp[start - 1] + 1);
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}