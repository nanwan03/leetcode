public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
       if (s3.length() != s1.length() + s2.length()) {
        	return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
        	dp[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }
        for (int j = 1; j <= s2.length(); j++) {
        	dp[0][j] = s2.substring(0, j).equals(s3.substring(0, j));
        }
        for (int i = 1; i <= s1.length(); i++) {
        	for (int j = 1; j <= s2.length(); j++) {
        		if (!dp[i][j] && dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
        			dp[i][j] = true;
        		}
        		if (!dp[i][j] && dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
        			dp[i][j] = true;
        		}
        	}
        }
        return dp[s1.length()][s2.length()];
    }
}