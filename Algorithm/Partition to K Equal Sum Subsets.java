class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        return helper(nums, new int[k], new boolean[nums.length + 1], 0, nums.length - 1, target);
    }
    private boolean helper(int[] nums, int[] subset, boolean[] isused, int curIndex, int limitIndex, int target) {
        if (curIndex == subset.length) {
            for (int i = 0; i < subset.length; ++i) {
                if (subset[i] != target) {
                    return false;
                }
            }
            return true;
        }
        if (subset[curIndex] == target) {
            return helper(nums, subset, isused, curIndex + 1, nums.length - 1, target);
        }
        for (int i = limitIndex; i >= 0; --i) {
            if (!isused[i]) {
                isused[i] = true;
                subset[curIndex] += nums[i];
                if (helper(nums, subset, isused, curIndex, i - 1, target)) {
                    return true;
                }
                isused[i] = false;
                subset[curIndex] -= nums[i];
            }
        }
        return false;
    }
}