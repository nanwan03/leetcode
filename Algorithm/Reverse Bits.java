public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if (n == 0) {
            return 0;
        }
        int rst = 0;
        for (int i = 0; i < 32; i++) {
            rst = (rst << 1) | (n & 1);
            n >>>= 1;
        }
        return rst;
    }
}