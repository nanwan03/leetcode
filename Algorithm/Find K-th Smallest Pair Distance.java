class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int left = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; ++i) {
            left = Math.min(left, nums[i] - nums[i - 1]);
        }
        int right = nums[nums.length - 1] - nums[0];
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (getCount(nums, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return getCount(nums, left) >= k ? left : right;
    }
    private int getCount(int[] array, int target) {
        int size = array.length;
        int rst = 0;
        for (int i = 0; i <  size; ++i) {
            for (int j = i + 1; j < size && array[j] - array[i] <= target; ++j) {
                rst++;
            }
        }
        return rst;
    }
}