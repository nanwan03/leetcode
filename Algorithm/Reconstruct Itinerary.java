public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList();
        if (tickets == null || tickets.length == 0) return result;

        Map<String, TreeMap<String, Integer>> map = new HashMap();

        for (String[] pair : tickets) {
            if (!map.containsKey(pair[0])) map.put(pair[0], new TreeMap());
            TreeMap<String, Integer> cache = map.get(pair[0]);
            cache.put(pair[1], cache.containsKey(pair[1]) ? cache.get(pair[1]) + 1 : 1);
        }
        dfs("JFK", map, result, tickets.length + 1);
        return result;
    }

    private boolean dfs(String curr, Map<String, TreeMap<String, Integer>> map, List<String> result, int size) {
        result.add(curr);
        if (result.size() == size) return true;
        if (map.containsKey(curr)) {
            TreeMap<String, Integer> children = map.get(curr);

            for (String next : children.keySet()) {
                if (children.get(next) > 0) {
                    children.put(next, children.get(next) - 1);
                    boolean res = dfs(next, map, result, size);
                    if (res) return true;
                    children.put(next, children.get(next) + 1);
                }
            }
        }
        result.remove(result.size() - 1);
        return false;
    }
}