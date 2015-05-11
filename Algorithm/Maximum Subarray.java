public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int tempMax = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            tempMax = Math.max(tempMax, 0) + A[i];
            max = Math.max(max, tempMax);
        }
        return max;
    }
}