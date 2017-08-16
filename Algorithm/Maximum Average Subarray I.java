public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long sum = 0;
        long max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i < k) {
                sum += nums[i];
                max = sum;
            } else {
                sum += nums[i] - nums[i - k];
                max = Math.max(max, sum);
            }
        }
        return (double)max / (double)k;
    }
}