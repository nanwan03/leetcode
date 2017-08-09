public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> rst = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        for (int i : nums) {
            if (nums[Math.abs(i) - 1] > 0) {
                nums[Math.abs(i) - 1] *= -1;
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                rst.add(i + 1);
            }
        }
        return rst;
    }
}