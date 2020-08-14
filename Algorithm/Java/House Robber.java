public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = nums.length;
        if (size == 1) {
            return nums[0];
        }
        int[] dp = new int[]{nums[0], Math.max(nums[0], nums[1])};
        for (int i = 2; i < nums.length; ++i) {
            int temp = Math.max(dp[0] + nums[i], dp[1]);
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return dp[1];
    }
}