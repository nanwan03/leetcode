public class Solution {
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int maxSoFar = 1;
        int minSoFar = 1;
        int max = Integer.MIN_VALUE;
        for (int i : A) {
            int tempMax = Math.max(Math.max(maxSoFar * i, minSoFar * i), i);
            int tempMin = Math.min(Math.min(maxSoFar * i, minSoFar * i), i);
            max = Math.max(max, tempMax);
            maxSoFar = tempMax;
            minSoFar = tempMin;
        }
        return max;
    }
}