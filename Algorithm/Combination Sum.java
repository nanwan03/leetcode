public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return rst;
        }
        List<Integer> items = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(rst, items, candidates, target, 0);
        return rst;
    }
    private void helper(List<List<Integer>> rst, List<Integer> items, int[] candidates, int target, int pos) {
        if (target == 0) {
            rst.add(new ArrayList<Integer>(items));
            return;
        } else if (target > 0) {
            for (int i = pos; i < candidates.length; i++) {
                items.add(candidates[i]);
                helper(rst, items, candidates, target - candidates[i], i);
                items.remove(items.size() - 1);
            }
        }
    }
}