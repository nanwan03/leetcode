public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return true;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int temp = matrix[mid / col][mid % col];
            if (temp == target) {
                return true;
            } else if (temp < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (matrix[left / col][left % col] == target) {
            return true;
        } else if (matrix[right / col][right % col] == target) {
            return true;
        } else {
            return false;
        }
    }
}