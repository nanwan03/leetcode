public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int tail = -1;
        for (int i : A) {
            if (i != elem) {
                A[++tail] = i;
            }
        }
        return ++tail;
    }
}