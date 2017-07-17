public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = nums.length;
        if (size == 1) {
            return nums[0];
        }
        return Math.max(helper(nums, 0, size - 2), helper(nums, 1, size - 1));
    }
    private int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int[] dp = new int[]{nums[start], Math.max(nums[start], nums[start + 1])};
        for (int i = start + 2; i <= end; ++i) {
            int temp = Math.max(dp[0] + nums[i], dp[1]);
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return dp[1];
    }
}