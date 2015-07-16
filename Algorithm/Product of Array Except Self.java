public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] rst = new int[nums.length];
        if (nums == null || nums.length < 2) {
            return rst;
        }
        long product = 1;
        for (int i = 0; i < nums.length; ++i) {
            rst[i] = (int)(product);
            product *= nums[i];
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            rst[i] = (int)(product * rst[i]);
            product *= nums[i];
        }
        return rst;
    }
}