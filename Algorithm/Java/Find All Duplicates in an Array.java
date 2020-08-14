public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> rst = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        for (int i : nums) {
            if (nums[Math.abs(i) - 1] < 0) {
                rst.add(Math.abs(i)); 
            } else {
                nums[Math.abs(i) - 1] *= -1;
            }
        }
        return rst;
    }
}