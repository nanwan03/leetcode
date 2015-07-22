public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return true;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int rIndex = 0;
        int cIndex = col - 1;
        int count = 0;
        while (rIndex < row && cIndex >= 0) {
            int temp = matrix[rIndex][cIndex];
            if (temp == target) {
                return true;
            } else if (temp < target) {
                rIndex++;
            }  else {
                cIndex--;
            }
        }
        return false;
    }
}