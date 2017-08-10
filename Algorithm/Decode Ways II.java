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
    private int ways(int ch) {
        if(ch == '*') {
            return 9;
        } else if(ch == '0') {
            return 0;
        }
        return 1;
    }

    private int ways(char ch1, char ch2) {
        String str = "" + ch1 + ch2;
        if (ch1 != '*' && ch2 != '*') {
            int val = Integer.parseInt(str);
            if (10 <= val && val <= 26) {
                return 1;
            } 
        } else if (str.equals("**")) {
                return 15;
        } else if (ch1 == '*') {
            return ('0' <= ch2 && ch2 <= '6') ? 2 : 1;
        } else {
            if (ch1 == '1') {
                return 9;
            } else if (ch1 == '2') {
                return 6;
            }
        }
        return 0;
    }
}