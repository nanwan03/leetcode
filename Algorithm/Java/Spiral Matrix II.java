public class Solution {
    private int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int[][] generateMatrix(int n) {
        int[][] rst = new int[n][n];
        if (n == 0) {
            return rst;
        }
        int x = 0;
        int y = 0;
        int dir = 0;
        for (int i = 1; i <= n * n; ++i) {
            rst[x][y] = i;
            int nx = x + dirs[dir][0];
            int ny = y + dirs[dir][1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || rst[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                nx = x + dirs[dir][0];
                ny = y + dirs[dir][1];
            }
            x = nx;
            y = ny;
        }
        return rst;
    }
}