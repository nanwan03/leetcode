public class Solution {
    public int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int num = noGreaterThan(nums, mid);
            if (num <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    private static int noGreaterThan(int[] nums, int mid) {
        int rst = 0;
        for (int i : nums) {
            if (i <= mid) {
                rst++;
            }
        }
        return rst;
    }
}