public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int cur = 0;
        int right = nums.length - 1;
        while (cur <= right) {
            if (nums[cur] != 0) {
                swap(nums, cur++, left++);
            } else {
                cur++;
            }
        }
        while (left < nums.length) {
            nums[left++] = 0;
        }
    }
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}