public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = -1;
        int rst = Integer.MAX_VALUE;
        int sum = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if (sum >= s) {
                while (start <= end) {
                    sum -= nums[start++];
                    if (sum < s) {
                        break;
                    }
                }
                rst = Math.min(rst, Math.max(end - start + 2, 0));
            }
            end = i;
            if (end < nums.length) {
            	sum += nums[end];
            }
        }
        return rst == Integer.MAX_VALUE ? 0 : rst;
    }
}