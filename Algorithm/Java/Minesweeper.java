public class Solution {
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        if (click == null || click.length == 0) {
            return board;
        }
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        helper(board, x, y, board.length, board[0].length);
        return board;
    }
    private void helper(char[][] board, int x, int y, int row, int col) {
        if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] != 'E')  {
            return;
        }
        int num = getNumsOfBombs(board, x, y, row, col);
        if (num == 0) {
            board[x][y] = 'B';
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                helper(board, nx, ny, row, col);
            }
        } else {
            board[x][y] = (char)('0' + num);
        }
        
    }
    
    private int getNumsOfBombs(char[][] board, int x, int y, int row, int col) {
        int num = 0;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                continue;
            }
            if (board[nx][ny] == 'M' || board[nx][ny] == 'X') {
                num++;
            }
        }
        return num;
    }
}