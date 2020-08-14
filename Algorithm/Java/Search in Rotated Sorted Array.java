public class Solution {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[left] < A[mid]) {
                if (A[left] <= target && target <= A[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (A[mid] <= target && target <= A[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (A[left] == target) {
            return left;
        } else if (A[right] == target) {
            return right;
        } else {
            return -1;
        }
    }
}