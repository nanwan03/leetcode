public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (k == 0 || n == 0) {
            return rst;
        }
        List<Integer> items = new ArrayList<Integer>();
        helper(k, n, rst, items, 1);
        return rst;
    }
    private void helper(int k, int n, List<List<Integer>> rst, List<Integer> items, int index) {
        if (k == 0 && n == 0) {
            rst.add(new ArrayList<Integer>(items));
            return;
        }
        if (k > 0 && n > 0) {
            for (int i = index; i <= 9; i++) {
                items.add(i);
                helper(k - 1, n - i, rst, items, i + 1);
                items.remove(items.size() - 1);
            }
        }
    }
}