public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean flag = helper(board, word, i, j, 0);
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, String word, int i, int j, int pos) {
        if (pos == word.length()) {
            return true;
        }
        int row = board.length;
        int col = board[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] == '.' || board[i][j] != word.charAt(pos)) {
            return false;
        }
        char c = board[i][j];
        board[i][j] = '.';
        boolean flag = helper(board, word, i + 1, j, pos + 1) ||
                        helper(board, word, i - 1, j, pos + 1) ||
                        helper(board, word, i, j + 1, pos + 1) ||
                        helper(board, word, i, j - 1, pos + 1);
        board[i][j] = c;
        return flag;
        
    }
}