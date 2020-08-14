public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	int start = 0;
    	int end = 0;
    	int rst = Integer.MAX_VALUE;
    	int tempSum = 0;
    	for (end = 0; end < nums.length; ++end) {
    		tempSum += nums[end];
			while (start < end && tempSum - nums[start] >= s) {
				tempSum -= nums[start];
				start++;
			}
			if (tempSum >= s) {
				rst = Math.min(rst, end - start + 1);
			}
    	}
    	return rst == Integer.MAX_VALUE ? 0 : rst;
    }
}