public class Solution {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] bits = new int[32];
        int rst = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                bits[i] += ((A[j] >> i) & 1);
            }
            bits[i] %= 3;
            rst |= bits[i] << i;
        }
        return rst;
    }
}