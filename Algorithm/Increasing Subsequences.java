public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        List<Integer> items = new ArrayList<Integer>();
        helper(rst, items, nums, 0);
        return rst;
    }
    private void helper(List<List<Integer>> rst, List<Integer> items, int[] nums, int index) {
        if (items.size() >= 2) {
            rst.add(new ArrayList<Integer>(items));
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = index; i < nums.length; ++i) {
            if (set.add(nums[i])) {
                if (items.size() == 0 || items.get(items.size() - 1) <= nums[i]) {
                    items.add(nums[i]);
                    helper(rst, items, nums, i + 1);
                    items.remove(items.size() - 1);
                }
            }
        }
    }
}