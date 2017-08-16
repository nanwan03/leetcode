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
            int value = nums[i];
            while (value != i && nums[value] >= 0) {
                length++;
                nums[value] *= -1;
                value = Math.abs(nums[value]);
            }
            rst = Math.max(rst, length);
        }
        return rst;
    }
}