public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        if(rows<1) return 0;
        int cols = matrix[0].length;
        int[][] matrixExt = new int[rows+2][cols+2], longest = new int[rows+2][cols+2]; // extended matrix and result matrix
        for(int i=0; i<rows; i++) {
            matrixExt[i][0] = matrixExt[i][cols+1] = 0x7fffffff; // boundary all MAX
            for(int j=0; j<cols; j++) {
                matrixExt[0][j] = matrixExt[rows+1][j] = 0x7fffffff;
                matrixExt[i+1][j+1] = matrix[i][j];
            }
        }
    
        int max = 1;
        for(int i=1; i<rows+1; i++) {
            for(int j=1; j<cols+1; j++) {
                int temp = helper(matrixExt, longest, rows, cols, i, j);
                max = temp > max ? temp : max;
            }
        }
        return max;
    }

    private int helper(int[][] matrix, int[][] longest, int rows, int cols, int i, int j) {
        if(i==0 || i==rows+1 || j==0 || j==cols+1) return 0; // margins
        if(longest[i][j]>0) return longest[i][j]; // reuse
        int max = 1; // result
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 4 different directions
        for(int[] d : dirs) {
            if(matrix[i][j] > matrix[i+d[0]][j+d[1]]) {
                int temp = helper(matrix, longest, rows, cols, i+d[0], j+d[1]) + 1; // recursively update longest[i][j]
                max = temp > max ? temp : max;
            }
        }
        longest[i][j] = max; // store for reuse
        return max;
    }
}