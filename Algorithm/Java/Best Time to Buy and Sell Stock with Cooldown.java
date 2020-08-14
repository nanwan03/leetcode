/*
 * buy[i]��ʾ�ڵ�i��֮ǰ���һ���������򣬴�ʱ��������档

	sell[i]��ʾ�ڵ�i��֮ǰ���һ��������������ʱ��������档
	
	rest[i]��ʾ�ڵ�i��֮ǰ���һ���������䶳�ڣ���ʱ��������档
	
	����д������ʽΪ��
	
	buy[i]  = max(rest[i-1] - price, buy[i-1]) 
	sell[i] = max(buy[i-1] + price, sell[i-1])
	rest[i] = max(sell[i-1], buy[i-1], rest[i-1])
	
	��������ʽ�ܺõı�ʾ������֮ǰ���䶳�ڣ���֮ǰҪ����֮ǰ�Ĺ�Ʊ��һ��С��������α�֤[buy, rest, buy]�����������֣���������buy[i] <= rest[i]�� ��rest[i] = max(sell[i-1], rest[i-1])���Ᵽ֤��[buy, rest, buy]������֡�
	
	���⣬�����䶳�ڵĴ��ڣ����ǿ��Եó�rest[i] = sell[i-1]�����������ǿ��Խ�������������ʽ����������
	
	buy[i]  = max(sell[i-2] - price, buy[i-1]) 
	sell[i] = max(buy[i-1] + price, sell[i-1])
	 
	
	���ǻ���������һ���Ż�������iֻ������i-1��i-2���������ǿ�����O(1)�Ŀռ临�Ӷ�����㷨
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] buy = new int[1];  //buy[i - 1]
        int[] sell = new int[2]; //sell[i - 1, i - 2]
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int price : prices) {
            int buy_cur = Math.max(sell[1] - price, buy[0]);
            int sell_cur = Math.max(buy[0] + price, sell[0]);
            buy[0] = buy_cur;
            sell[1] = sell[0];
            sell[0] = sell_cur;
        }
        return sell[0];
    }
}