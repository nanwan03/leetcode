public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> rst = new ArrayList<String[]>();
        if (n == 0) {
            return rst;
        }
        List<Integer> cols = new ArrayList<Integer>();
        helper(rst, cols, n);
        return rst;
    }
    private void helper(List<String[]> rst, List<Integer> cols, int n) {
        if (n == cols.size()) {
            rst.add(drawBoard(cols));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(cols, i)) {
                cols.add(i);
                helper(rst, cols, n);
                cols.remove(cols.size() - 1);
            }
        }
    }
    private boolean isValid(List<Integer> cols, int rowToPut) {
        int colSize = cols.size();
        for (int i = 0; i< cols.size(); i++) {
            int diff = Math.abs(rowToPut - cols.get(i));
            if (diff == 0 || diff == cols.size() - i) {
                return false;
            }
        }
        return true;
    }
    private String[] drawBoard(List<Integer> cols) {
        String[] board = new String[cols.size()];
        for (int i = 0; i < cols.size(); i++) {
            board[i] = "";
            for (int j = 0; j < cols.size(); j++) {
                if (cols.get(i) == j) {
                    board[i] += "Q";
                } else {
                    board[i] += ".";
                }
            }
        }
        return board;
    }
}