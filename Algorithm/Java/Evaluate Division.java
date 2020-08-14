public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<String>> edges = new HashMap<String, List<String>>();
        Map<String, List<Double>> weights = new HashMap<String, List<Double>>();
        for (int i = 0; i < equations.length; i++) {
            String v1 = equations[i][0];
            String v2 = equations[i][1];
            if (!edges.containsKey(v1)) {
                edges.put(v1, new ArrayList<String>());
                weights.put(v1, new ArrayList<Double>());
            }
            if (!edges.containsKey(v2)) {
                edges.put(v2, new ArrayList<String>());
                weights.put(v2, new ArrayList<Double>());
            }
            edges.get(v1).add(v2);
            edges.get(v2).add(v1);
            weights.get(v1).add(values[i]);
            weights.get(v2).add(1.0 / values[i]);
        }
        
        double[] rst = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            rst[i] = helper(query[0], query[1], edges, weights, new HashSet<String>(), 1.0);
            if (rst[i] == 0.0) {
                rst[i] = -1.0;
            }
        }
        return rst;
    }
    private double helper(String start, String end, Map<String, List<String>> edges, Map<String, List<Double>> weights, Set<String> set, double value) {
        if (set.contains(start) || !edges.containsKey(start)) {
            return 0.0;
        }
        if (start.equals(end)) {
            return value;
        }
        set.add(start);
        List<String> edge = edges.get(start);
        List<Double> weight = weights.get(start);
        double rst = 0.0;
        for (int i = 0; i < edge.size(); i++) {
            rst = helper(edge.get(i), end, edges, weights, set, value * weight.get(i));
            if (rst != 0.0) {
                break;
            }
        }
        set.remove(start);
        return rst;
    }
}