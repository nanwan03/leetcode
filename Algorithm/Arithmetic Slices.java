public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int temp = 0;
        int rst = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                temp++;
            } else {
                temp = 0;
            }
            rst += temp;
        }
        return rst;
    }
}