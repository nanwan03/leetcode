public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>(wordDict);
        if (s == null || s.length() == 0) {
          return set.isEmpty();
        }
        int maxLength = 0;
        for (String word : set) {
            maxLength = Math.max(maxLength, word.length());
        }
        int size = s.length();
        boolean[] dp = new boolean[size + 1];
        dp[0] = true;
        for (int i = 1; i <= size; i++) {
            for (int j = i - 1; j >= 0 && !dp[i] && i - j <= maxLength; j--) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[size];
    }
}