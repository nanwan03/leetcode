public class Solution {
    public int countDigitOne(int n) {
        if (n < 0) {
            return 0;
        }
        int cur = n;
        int right = 0;
        int rst = 0;
        while (cur != 0) {
            if (cur % 10 > 1) {
                rst += (cur / 10 + 1) * Math.pow(10, right);
            } else if (cur % 10 == 1) {
                rst += (cur / 10) * Math.pow(10, right) + n % (int)(Math.pow(10, right)) + 1;
            } else {
                rst += (cur / 10) * Math.pow(10, right);
            }
            cur /= 10;
            right++;
        }
        return rst;
    }
}