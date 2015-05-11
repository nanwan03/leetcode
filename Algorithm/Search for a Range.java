public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] rst = new int[]{-1, -1};
        if (A == null || A.length == 0) {
            return rst;
        }
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                right = mid;
            } else if (A[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (A[left] == target) {
            rst[0] = left;
        } else if (A[right] == target) {
            rst[0] = right;
        } else {
            return rst;
        }
        left = 0;
        right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                left = mid;
            } else if (A[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (A[right] == target) {
            rst[1] = right;
        } else if (A[left] == target) {
            rst[1] = left;
        }
        return rst;
    }
}