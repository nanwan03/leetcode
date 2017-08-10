public class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long max = 0; 
        long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        if (m == 1) {
            return (int)sum;
        }
        long left = max; 
        long right = sum;
        while (left + 1 <= right) {
            long mid = left + (right - left) / 2;
            if (isValid(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (isValid(nums, m, left)) {
            return (int)left;
        } else {
            return (int)right;
        }
    }
    public boolean isValid(int[] nums, int m, long target) {
        int count = 1;
        long total = 0;
        for (int num : nums) {
            if (total + num > target) {
                total = 0;
                count++;
            }
            total += num;
        }
        return count <= m;
    }
}