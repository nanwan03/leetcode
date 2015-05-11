public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
            return false;
        }
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (dict.contains(s.substring(0, i + 1))) {
                dp[i] = true;
            } else {
                for (int j = 0; j < i && !dp[i]; j++) {
                    if (dp[j] && dict.contains(s.substring(j + 1, i + 1))) {
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}