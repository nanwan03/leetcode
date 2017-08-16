public class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rst = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 1) {
                    rst += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        rst -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        rst -= 2;
                    }
                }
            }
        }
        return rst;
    }
}