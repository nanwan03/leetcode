public class Solution {
    public int trailingZeroes(int n) {
        long rst = 0;
        while (n != 0) {
            rst += n / 5;
            n = n / 5;
        }
        return (int)rst;
    }
}