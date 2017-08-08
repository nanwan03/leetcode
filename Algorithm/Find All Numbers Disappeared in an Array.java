public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> rst = new ArrayList<>();
        int size = nums.length;
        for (int i = 0; i < size; i ++) {
            nums[(nums[i]-1) % size] += size;
        }
        for (int i = 0; i < size; i ++) {
            if (nums[i] <= size) {
                rst.add(i + 1);
            }
        }
        return rst;
    }
}