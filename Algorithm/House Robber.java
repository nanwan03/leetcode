public class Solution {
    public int rob(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int maxPrev = Math.max(num[0], num[1]);
        int max2Before = num[0];
        for (int i = 2; i < num.length; i++) {
            int tempMax = Math.max(max2Before + num[i], maxPrev);
            max2Before = maxPrev;
            maxPrev = tempMax;
        }
        return maxPrev;
    }
}