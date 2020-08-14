public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length-1, new Integer[nums.length][nums.length]) >= 0;
    }
    private int helper(int[] nums, int left, int right, Integer[][] dp) {      
        if (dp[left][right] == null) {
            dp[left][right] = left == right ? nums[right] : Math.max(nums[right] - helper(nums, left, right - 1, dp), nums[left] - helper(nums, left + 1, right, dp));
        }
        return dp[left][right];
    }
}