public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) { 
            return true; 
        }
        int size = nums.length;
        int[] dp = new int[size];
        for (int i = size - 1; i >= 0; --i) {
            for (int j = i; j < size; ++j) {
                if (i == j) {
                    dp[i] = nums[i];
                } else {
                    dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
                }
            }
        }
        return dp[size - 1] >= 0;
    }
}