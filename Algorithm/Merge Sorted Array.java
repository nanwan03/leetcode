public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null) {
            return;
        }
        int tail = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (m >= 0 && n >= 0) {
            if (A[m] >= B[n]) {
                A[tail--] = A[m--];
            } else {
                A[tail--] = B[n--];
            }
        }
        while (m >= 0) {
            A[tail--] = A[m--];
        }
        while (n >= 0) {
            A[tail--] = B[n--];
        }
    }
}