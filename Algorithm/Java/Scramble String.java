public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int size = s1.length();
        boolean[][][] dp = new boolean[size + 1][size][size];
        for (int len = 1; len <= size; ++len) {
            for (int i = size - len; i >= 0; --i) {
                for (int j = size - len; j >= 0; --j) {
                    if (len == 1) {
                        dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
                    } else {
                        for (int k = 1; k < len && !dp[len][i][j]; ++k) {
                            dp[len][i][j] = (dp[k][i][j] && dp[len - k][i + k][j + k]) || (dp[k][i + len - k][j] && dp[len - k][i][j + k]);
                        }
                    }
                }
            }
        }
        return dp[size][0][0];
    }
}