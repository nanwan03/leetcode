public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (n == 0 || k == 0) {
            return rst;
        }
        List<Integer> items = new ArrayList<Integer>();
        helper(rst, items, n, k, 1);
        return rst;
    }
    private void helper(List<List<Integer>> rst, List<Integer> items, int n, int k, int pos) {
        if (k == 0) {
            rst.add(new ArrayList<Integer>(items));
            return;
        } else if (k > 0) {
            for (int i = pos; i <= n; i++) {
                items.add(i);
                helper(rst, items, n, k - 1, i + 1);
                items.remove(items.size() - 1);
            }
        }
    }
}