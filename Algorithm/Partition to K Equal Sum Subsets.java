class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        int index = nums.length - 1;
        if (nums[index] > target) {
            return false;
        }
        while (index >= 0 && nums[index] == target) {
            index--;
            k--;
        }
        return helper(new int[k], index, nums, target);
    }
    private boolean helper(int[] group, int index, int[] nums, int target) {
        if (index < 0) {
            for (int i = 0; i < group.length; ++i) {
                if (group[i] != target) {
                    return false;
                }
            }
            return true;
        }
        int num = nums[index--];
        for (int i = 0; i < group.length; ++i) {
            if (group[i] + num  <= target) {
                group[i] += num;
                if (helper(group, index, nums, target)) {
                    return true;
                }
                group[i] -= num;
            }
            if (group[i] == 0) {
                break;
            }
        }
        return false;
    }
}