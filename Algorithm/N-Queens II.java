public class Solution {
    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }
        List<Integer> cols = new ArrayList<Integer>();
        return helper(cols, n);
    }
    private int helper(List<Integer> cols, int n) {
        if (n == cols.size()) {
            return 1;
        }
        int rst = 0;
        for (int i = 0; i < n; ++i) {
            if (isValid(cols, i)) {
                cols.add(i);
                rst += helper(cols, n);
                cols.remove(cols.size() - 1);
            }
        }
        return rst;
    }
    private boolean isValid(List<Integer> cols, int rowToPut) {
        for (int i = 0; i < cols.size(); ++i) {
            int diff = Math.abs(cols.get(i) - rowToPut);
            if (diff == 0 || diff == (cols.size() - i)) {
                return false;
            }
        }
        return true;
    }
}