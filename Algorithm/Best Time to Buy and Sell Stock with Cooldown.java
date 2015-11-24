import java.util.Arrays;

public class Solution {
    public int maxProfit(int[] prices) {
        int[] full = new int[2];
        int[] empty = new int[2];
        int[] sell = new int[2];
        Arrays.fill(full, Integer.MIN_VALUE);
        Arrays.fill(empty, 0);
        Arrays.fill(sell, 0);
        for (int i = 0; i < prices.length; i++) {
            full[i % 2] = Math.max(full[1 - i % 2], empty[1 - i % 2] - prices[i]);  
                // had bought before OR buy today (pay prices[i])
            sell[i % 2] = full[1 - i % 2] + prices[i];  
                // sell today (get prices[i])
            empty[i % 2] = Math.max(empty[1 - i % 2], sell[1 - i % 2]);  
                // had sold before yesterday OR sold yesterday
        }
        return Math.max(empty[1 - prices.length % 2], sell[1 - prices.length % 2]);
    }
}