public class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
          return 0;
        }
        int num0 = 0;
        int num1 = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int rst = 0;
        for (int i = 0; i < nums.length; ++i) {
          num0 += 1 - nums[i];
          num1 += nums[i];
          int diff = num0 - num1;
          if (diff == 0) {
            rst = Math.max(rst, i + 1);
          } else if (map.containsKey(diff)) {
            rst = Math.max(rst, i - map.get(diff));
          } else {
            map.put(diff, i);
          }
        }
        return rst;
    }
}