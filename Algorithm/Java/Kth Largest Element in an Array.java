public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findK(nums, 0, nums.length - 1, nums.length - k);
    }
    private int findK(int[] nums, int left, int right, int k) {
        java.util.Random r = new java.util.Random();
        while (left < right) {
            int pivot = partition(nums, left, right, r.nextInt(right - left + 1) + left);
            if (pivot == k) {
                return nums[pivot];
            } else if (pivot < k) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return left == k ? nums[left] : nums[right];
    }
    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        int cur = left;
        while (cur <= right) {
            if (nums[cur] < pivotValue) {
                swap(nums, left++, cur++);
            } else if (nums[cur] == pivotValue) {
                cur++;
            } else {
                swap(nums, cur, right--);
            }
        }
        return left;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}