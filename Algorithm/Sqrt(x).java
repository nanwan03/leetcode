public class Solution {
    public int sqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        long left = 1;
        long right = x;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int)(mid);
            } else if (mid * mid < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (int)(Math.min(left, right));
    }
}