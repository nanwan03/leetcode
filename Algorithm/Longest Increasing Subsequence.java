public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int rst = 0;
        for(int i : nums) {
            int index = Arrays.binarySearch(dp, 0, rst, i);
            if(index < 0) {
                index = -(index + 1);
            }
            dp[index] = i;
            if(index == rst) {
                rst++;
            }
        }

        return rst;
    }
}