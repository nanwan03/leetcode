class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long sum = 0;
        long max = 0;
        for (int i : nums) {
            sum += i;
            max = Math.max(max, i);
        }
        return helper(nums, m, max, sum);
    }
    private int helper(int[] nums, int m, long left, long right) {
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (isValid(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return isValid(nums, m, left) ? (int)left :  (int)right;
    }
    private boolean isValid(int[] nums, int m, long target) {
        int count = 1;
        long sum = 0;
        for (int i : nums) {
            if (sum + i > target) {
                count++;
                sum = 0;
            }
            sum += i;
        }
        return count <= m;
    }
}