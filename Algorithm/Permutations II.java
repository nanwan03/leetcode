public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        helper(rst, nums, 0);
        return rst;
    }
    private void helper(List<List<Integer>> rst, int[] nums, int pos) {
        if (pos == nums.length) {
            rst.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = pos; i < nums.length; ++i) {
            if (set.add(nums[i])) {
                swap(nums, pos, i);
                helper(rst, nums, pos + 1);
                swap(nums, pos, i);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}