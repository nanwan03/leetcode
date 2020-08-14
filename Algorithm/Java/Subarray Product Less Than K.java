class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int product = 1;
        int rst = 0;
        int left = 0;
        for (int i = 0; i < nums.length; ++i) {
            product *= nums[i];
            while (left <= i && product >= k) {
                product /= nums[left++];
            }
            if (product < k) {
                rst += i - left + 1;
            }
        }
        return rst;
    }
}