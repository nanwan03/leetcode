class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = nums.length;
        int[] len = new int[size];
        int[] count = new int[size];
        Arrays.fill(len, 1);
        Arrays.fill(count, 1);
        int rst = 0;
        int max = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1) {
                        count[i] += count[j];
                    } else if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if (len[i] == max) {
                rst += count[i];
            } else if (len[i] > max) {
                max = len[i];
                rst = count[i];
            }
        }
        return rst;
    }
}