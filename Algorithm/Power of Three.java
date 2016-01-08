public class Solution {
    public boolean isPowerOfThree(int n) {
        return n == 0 ? false : n == Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
    }
}