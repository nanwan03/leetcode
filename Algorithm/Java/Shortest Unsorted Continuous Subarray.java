public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int start = 0;
        int end = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
    
        for (int l = 0, r = nums.length - 1; r >= 0; l++, r--) {
            max = Math.max(max, nums[l]);
            if (nums[l] != max) {
                end = l;
            }

            min = Math.min(min, nums[r]);
            if (nums[r] != min) {
                start = r;
            }
        }

        return (end - start + 1);
    }
}