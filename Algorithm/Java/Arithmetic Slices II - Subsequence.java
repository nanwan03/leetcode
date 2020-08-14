public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int rst = 0;
        Map<Integer, Integer>[] dp = new Map[A.length];
		
        for (int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<Integer, Integer>();
            for (int j = 0; j < i; j++) {
                long diff = (long)A[i] - A[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }
                int d = (int)diff;
                int c1 = dp[i].getOrDefault(d, 0);
                int c2 = dp[j].getOrDefault(d, 0);
                rst += c2;
                dp[i].put(d, c1 + c2 + 1);
            }
        }
        return rst;
    }
}