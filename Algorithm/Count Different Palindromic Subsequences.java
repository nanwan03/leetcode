class Solution {
    private static final int MOD = 1000000007;
    public int countPalindromicSubsequences(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        TreeSet<Integer>[] set = new TreeSet[26];
        for (int i = 0; i < set.length; ++i) {
            set[i] = new TreeSet<Integer>();
        }
        for (int i = 0; i < S.length(); ++i) {
            set[S.charAt(i) - 'a'].add(i);
        }
        Integer[][] dp = new Integer[S.length() + 1][S.length() + 1];
        return helper(S, set, dp, 0, S.length());
    }
    private int helper(String S, TreeSet<Integer>[] set, Integer[][] dp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        long rst = 0;
        for (int i = 0; i < 26; ++i) {
            Integer newStart = set[i].ceiling(start);
            Integer newEnd = set[i].lower(end);
            if (newStart == null || newStart >= end) {
                continue;
            }
            rst++;
            if (newStart != newEnd) {
                rst++;
            }
            rst += helper(S, set, dp, newStart + 1, newEnd);
        }
        dp[start][end] = (int)(rst % MOD);
        return dp[start][end];
    }
}