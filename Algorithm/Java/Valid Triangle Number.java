public class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
          return 0;
        }
        Arrays.sort(nums);
        int rst = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
          int left = 0;
          int right = i - 1;
          while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > nums[i]) {
              rst += right - left;
              right--;
            } else {
              left++;
            }
          }
        }
        return rst;
    }
}