class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            } else if (i - map.get(sum) >= 2) {
                return true;
            }
        }
        return false;
    }
}