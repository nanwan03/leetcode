public class Solution {
    public int findLHS(int[] nums) {
        int rst = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }
        for (int num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                rst = Math.max(rst, map.get(num) + map.get(num + 1));
            }
        }
        return rst;
    }
}