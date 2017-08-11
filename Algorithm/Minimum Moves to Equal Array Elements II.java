public class Solution {
    public int minMoves2(int[] A) {
        int sum = 0;
        int median = findK(A, A.length / 2 + 1);
        for (int i = 0; i < A.length; i++) {
            sum += Math.abs(A[i] - median);
        }
        return sum;
    }
    private int findK(int[] nums, int k) {
        if (k == 0 || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        Random r = new Random();
        while (left < right) {
            int pIndex = partition(nums, left, right, nums[r.nextInt(right - left + 1) + left]);
            if (pIndex == k - 1) {
                return nums[pIndex];
            } else if (pIndex < k - 1) {
                left = pIndex + 1;
            } else {
                right = pIndex - 1;
            }
        }
        return nums[k - 1];
    }
    private int partition(int[] nums, int left, int right, int pVal) {
        int cur = left;
        while (cur <= right) {
            if (nums[cur] < pVal) {
                swap(nums, cur++, left++);
            } else if (nums[cur] == pVal) {
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