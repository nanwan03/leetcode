public class Solution {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        int left = 0;
        int cur = 0;
        int right = A.length - 1;
        while (cur <= right) {
            if (A[cur] == 0) {
                swap(A, cur++, left++);
            } else if (A[cur] == 1) {
                cur++;
            } else {
                swap(A, cur, right--);
            }
        }
    }
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}