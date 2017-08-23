class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int num0 = 0;
        int num1 = 0;
        int rst = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; ++i) {
            num0 += 1 - nums[i];
            num1 += nums[i];
            int diff = num1 - num0;
            if (!map.containsKey(diff)) {
                map.put(diff, i);
            } else {
                rst = Math.max(rst, i - map.get(diff));
            }
        }
        return rst;
    }
}