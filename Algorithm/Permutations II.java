public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return rst;
        }
        List<Integer> items = new ArrayList<Integer>();
        for (int i : num) {
            items.add(i);
        }
        helper(rst, items, 0);
        return rst;
    }
    private void helper(List<List<Integer>> rst, List<Integer> items, int pos) {
        if (pos == items.size()) {
            rst.add(new ArrayList<Integer>(items));
            return;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = pos; i < items.size(); i++) {
            if (set.add(items.get(i))) {
                Collections.swap(items, i, pos);
                helper(rst, items, pos + 1);
                Collections.swap(items, i, pos);
            }
        }
    }
}