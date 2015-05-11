public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return rst;
        }
        Arrays.sort(num);
        List<Integer> items = new ArrayList<Integer>();
        helper(rst, items, num, 0);
        return rst;
    }
    private void helper(List<List<Integer>> rst, List<Integer> items, int[] num, int pos) {
        rst.add(new ArrayList<Integer>(items));
        for (int i = pos; i < num.length; i++) {
            if (i > pos && num[i] == num[i - 1]) {
                continue;
            }
            items.add(num[i]);
            helper(rst, items, num, i + 1);
            items.remove(items.size() - 1);
        }
    }
}