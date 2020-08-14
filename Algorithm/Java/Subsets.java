public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (S == null || S.length == 0) {
            return rst;
        }
        Arrays.sort(S);
        List<Integer> items = new ArrayList<Integer>();
        helper(rst, items, S, 0);
        return rst;
    }
    private void helper(List<List<Integer>> rst, List<Integer> items, int[] S, int pos) {
        rst.add(new ArrayList<Integer>(items));
        for (int i = pos; i < S.length; i++) {
            items.add(S[i]);
            helper(rst, items, S, i + 1);
            items.remove(items.size() - 1);
        }
    }
}