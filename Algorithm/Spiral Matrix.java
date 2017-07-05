public class Solution {
    private int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rst = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return rst;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int x = 0;
        int y = 0;
        int dir = 0;
        for (int i = 0; i < row * col; ++i) {
            rst.add(matrix[x][y]);
            matrix[x][y] = 0;
            int nx = x + dirs[dir][0];
            int ny = y + dirs[dir][1];
            if (nx < 0 || nx >= row || ny < 0 || ny >= col || matrix[nx][ny] == 0) {
                dir = (dir + 1) & 3;
                nx = x + dirs[dir][0];
                ny = y + dirs[dir][1];
            }
            x = nx;
            y = ny;
        }
        return rst;
    }
}