public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rst = 0;
        for (int i = 0; i< grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    rst++;
                    mark(grid, i, j);
                }
            }
        }
        return rst;
    }
    private void mark(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
        	return;
        }
        grid[i][j] = '0';
        mark(grid, i + 1, j);
        mark(grid, i - 1, j);
        mark(grid, i, j + 1);
        mark(grid, i, j - 1);
    }
}