public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return reverse(x) == x;
    }
    private int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int reversedNum = 0;
        while (x != 0) {
            reversedNum = reversedNum * 10 + x % 10;
            x /= 10;
        }
        return reversedNum;
    }
}