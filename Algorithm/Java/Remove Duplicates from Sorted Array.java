public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int tail = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                A[++tail] = A[i];
            }
        }
        return ++tail;
    }
}