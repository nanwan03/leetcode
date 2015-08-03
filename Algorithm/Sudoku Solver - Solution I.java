public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    board[i][j] = (char)(k + '0');
                    if (isValid(board, i, j) && solve(board)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int row, int col) {
        boolean[] visited = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (!check(board[i][col], visited)) {
                return false;
            }
        }
        Arrays.fill(visited, false);
        for (int i = 0; i < 9; i++) {
            if (!check(board[row][i], visited)) {
                return false;
            }
        }
        Arrays.fill(visited, false);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!check(board[row / 3 * 3 + i][col / 3 * 3 + j], visited)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean check(char c, boolean[] visited) {
        if (c == '.') {
            return true;
        }
        int temp = c - '1';
        if (visited[temp]) {
            return false;
        }
        visited[temp] = true;
        return true;
    }
}