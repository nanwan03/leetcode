public class Solution {
    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int rst = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < 0) {
                continue;
            }
            int length = 1;
            int val = nums[i];
            while (Math.abs(val) != i) {
                length++;
                val = nums[Math.abs(val)];
                nums[Math.abs(val)] *= -1;
            }
            rst = Math.max(rst, length);
        }
        return rst;
    }
}