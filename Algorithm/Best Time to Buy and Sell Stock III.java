public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int tempMax = Integer.MIN_VALUE;
        int[] leftMax = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            tempMax = Math.max(tempMax, prices[i] - min);
            leftMax[i] = tempMax;
        }
        int max = Integer.MIN_VALUE;
        tempMax = Integer.MIN_VALUE;
        int[] rightMax = new int[prices.length];
        for (int i = prices.length - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            tempMax = Math.max(tempMax, max - prices[i]);
            rightMax[i] = tempMax;
        }
        int rst = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            rst = Math.max(rst, leftMax[i] + rightMax[i]);
        }
        return rst;
    }
}