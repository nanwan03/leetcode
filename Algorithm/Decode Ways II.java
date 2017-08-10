public class Solution {
    private static final long MOD = 1000000007;
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        long[] dp = new long[]{1, ways(s.charAt(0))};
        for(int i = 1; i < s.length(); i++) {
            long temp = (dp[1] * ways(s.charAt(i)) + dp[0] * ways(s.charAt(i-1), s.charAt(i))) % MOD;
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return  (int)dp[1];
    }
    private int ways(char c) {
        if(c == '*') {
            return 9;
        } else if(c == '0') {
            return 0;
        }
        return 1;
    }

    private int ways(char c1, char c2) {
        String str = "" + c1 + c2;
        if (c1 != '*' && c2 != '*') {
            int val = Integer.parseInt(str);
            if (10 <= val && val <= 26) {
                return 1;
            } 
        } else if (str.equals("**")) {
                return 15;
        } else if (c1 == '*') {
            return ('0' <= c2 && c2 <= '6') ? 2 : 1;
        } else {
            if (c1 == '1') {
                return 9;
            } else if (c1 == '2') {
                return 6;
            }
        }
        return 0;
    }
}