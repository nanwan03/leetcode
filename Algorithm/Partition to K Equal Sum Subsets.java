class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        return helper(nums, new boolean[nums.length], 0, k, 0, 0, sum / k);
    }
    private boolean helper(int[] nums, boolean[] isused, int startIndex, int k, int curSum, int curNum, int target) {
        if (k == 1) {
            return true;
        }
        if (curSum > target) { //nums[i] > 0
            return false;
        }
        if (curSum == target && curNum > 0) {
            return helper(nums, isused, 0, k-1, 0, 0, target);
        }
        for (int i = startIndex; i < nums.length; ++i){
            if (!isused[i]) {
                isused[i] = true;
                if (helper(nums, isused, i + 1, k, curSum + nums[i], curNum++, target)) {
                    return true;
                }
                isused[i] = false;
            }
        }
        return false;
    }
}