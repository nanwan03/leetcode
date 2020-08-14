public class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        int rst = 0;
        int aNum = Integer.valueOf('A');
        for (char c : s.toCharArray()) {
        	int digit = c - aNum + 1;
        	rst = rst * 26 + digit;
        }
        return rst;
    }
}