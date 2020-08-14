class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int rst = 0;
        for (int i = 0; i < nums.length; ++i) {
            int index = binarySearch(dp, 0, rst - 1, nums[i]);
            dp[index] = nums[i];
            if (index == rst) {
                rst++;
            }
        }
        return rst;
    }
    private int binarySearch(int[] dp, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (dp[mid] == target) {
                return mid;
            } else if (dp[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}