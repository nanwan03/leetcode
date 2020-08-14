public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return (sum < s || (s + sum) % 2 > 0) ? 0 : subsetSum(nums, (s + sum) >>> 1); 
    }
    private int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1]; 
        dp[0] = 1;
        for (int n : nums) {
            for (int i = s; i >= n; i--) {
                dp[i] += dp[i - n]; 
            }
        }
        return dp[s];
    }
}