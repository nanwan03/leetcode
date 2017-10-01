class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] rst = new int[3];
        if (nums == null || nums.length == 0) {
            return rst;
        }
        int size = nums.length;
        int[] sum = new int[size + 1];
        for (int i = 1; i <= size; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int[] left = new int[size];
        int leftM = sum[k];
        for (int i = k; i < size; ++i) {
            if (sum[i + 1] - sum[i + 1 - k] > leftM) {
                leftM = sum[i + 1] - sum[i + 1 - k];
                left[i] = i + 1 - k;
            } else {
                left[i] = left[i - 1];
            }
        }
        int[] right = new int[size];
        right[size - k] = size - k;
        int rightM = sum[size] - sum[size - k];
        for (int i = size - 1 - k; i >= 0; --i) {
            if (sum[i + k] - sum[i] > rightM) {
                rightM = sum[i + k] - sum[i];
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = k; i <= size - 2 * k; ++i) {
            int leftBound = left[i - 1];
            int rightBound = right[i + k];
            int temp = (sum[leftBound + k] - sum[leftBound]) + (sum[i + k] - sum[i]) + (sum[rightBound + k] - sum[rightBound]);
            if (temp > max) {
                max = temp;
                rst = new int[]{leftBound, i, rightBound};
            }
        }
        return rst;
    }
}