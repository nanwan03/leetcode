public class Solution {
    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        int rst = 0;
        while (x != 0) {
            if (Math.abs(rst) > 214748364) {
                return 0;
            }
            rst = rst * 10 + x % 10;
            x /= 10;
        }
        return rst;
    }
}