public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int size = s.length();
        int[] dp = new int[]{1, ways(s.charAt(0))};
        for (int i = 1; i < size; ++i) {
            int temp = (dp[1] * ways(s.charAt(i)) + dp[0] * ways(s.substring(i - 1, i + 1)));
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return dp[1];
    }
    private int ways(char c) {
        return c == '0' ? 0 : 1;
    }
    private int ways(String sub) {
        int val = Integer.parseInt(sub);
        return 10 <= val && val <= 26 ? 1 : 0;
    }
}