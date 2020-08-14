public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> rst = new ArrayList<String>();
        if (tickets == null || tickets.length == 0) {
            return rst;
        }
        Map<String, TreeMap<String, Integer>> map = new HashMap<String, TreeMap<String, Integer>>();
        for (String[] pair : tickets) {
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], new TreeMap<String, Integer>());
            }
            TreeMap<String, Integer> cache = map.get(pair[0]);
            if (!cache.containsKey(pair[1])) {
                cache.put(pair[1], 1);
            } else {
                cache.put(pair[1], cache.get(pair[1]) + 1);
            }
        }
        rst.add("JFK");
        if(helper("JFK", map, rst, tickets.length + 1)) {
            return rst;
        }
        rst.remove(rst.size() - 1);
        return rst;
    }
    private boolean helper(String cur, Map<String, TreeMap<String, Integer>> map, List<String> rst, int size) {
        if (rst.size() == size) {
            return true;
        }
        if (map.containsKey(cur)) {
            TreeMap<String, Integer> next = map.get(cur);
            for (String nextStop : next.keySet()) {
                if (next.get(nextStop) > 0) {
                    rst.add(nextStop);
                    next.put(nextStop, next.get(nextStop) - 1);
                    boolean flag = helper(nextStop, map, rst, size);
                    if (flag) {
                        return true;
                    }
                    next.put(nextStop, next.get(nextStop) + 1);
                    rst.remove(rst.size() - 1);
                }
            }
        };
        return false;
    }
}