public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return rst;
        }
        Arrays.sort(num);
        List<Integer> items = new ArrayList<Integer>();
        helper(rst, items, num, target, 0);
        return rst;
    }
    private void helper(List<List<Integer>> rst, List<Integer> items, int[] num, int target, int pos) {
        if (target == 0) {
            rst.add(new ArrayList<Integer>(items));
            return;
        } else if (target > 0) {
            for (int i = pos; i < num.length; i++) {
                if (i > pos && num[i] == num[i - 1]) {
                    continue;
                }
                items.add(num[i]);
                helper(rst, items, num, target - num[i], i + 1);
                items.remove(items.size() - 1);
            }
        }
    }
}