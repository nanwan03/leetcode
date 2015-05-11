public class Solution {
    private int rst = 0;
    public int totalNQueens(int n) {
        if (n == 0) {
            return rst;
        }
        List<Integer> cols = new ArrayList<Integer>();
        helper(cols, n);
        return rst;
    }
    private void helper(List<Integer> cols, int n) {
        if (cols.size() == n) {
            rst++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(cols, i)) {
                cols.add(i);
                helper(cols, n);
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
}