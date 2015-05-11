public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (A[right] < target) {
            return right + 1;
        } else if (A[left] < target || A[right] == target) {
            return right;
        } else {
            return left;
        }
    }
}