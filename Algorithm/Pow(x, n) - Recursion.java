public class Solution {
    public double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            x = 1.0 / x;
            n = -n;
        }
        double temp1 = pow(x, n / 2);
        double temp2 = (n % 2 == 0) ? 1.0 : x;
        return temp1 * temp1 * temp2;
    }
}