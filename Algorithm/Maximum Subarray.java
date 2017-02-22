public class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxSoFar = Integer.MIN_VALUE;
        for (int i : nums) {
          maxSoFar = Math.max(maxSoFar, 0) + i;
          max = Math.max(max, maxSoFar);
        }
        return max;
    }
}