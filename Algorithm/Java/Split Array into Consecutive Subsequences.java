public class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Map<Integer, Integer> wait = new HashMap<Integer, Integer>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (map.get(i) == 0) {
                continue;
            } else if (wait.getOrDefault(i, 0) > 0) {
                wait.put(i, wait.get(i) - 1);
                wait.put(i + 1, wait.getOrDefault(i + 1, 0) + 1);
            } else if (map.getOrDefault(i + 1, 0) > 0 && map.getOrDefault(i + 2, 0) > 0) {
                map.put(i + 1, map.get(i + 1) - 1);
                map.put(i + 2, map.get(i + 2) - 1);
                wait.put(i + 3, wait.getOrDefault(i + 3,0) + 1);
            } else {
                return false;
            }
            map.put(i, map.get(i) - 1);
        }
        return true;
    }
}