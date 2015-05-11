public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        int rst = 0;
        while (n != 0) {
            rst += (n & 1);
            n >>>= 1;
        }
        return rst;
    }
}