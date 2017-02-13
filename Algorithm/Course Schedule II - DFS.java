public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] rst = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            rst[i] = i;
        }
        if (numCourses == 0 || numCourses == 1 || prerequisites == null || prerequisites.length == 0) {
            return rst;
        }
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] dep : prerequisites) {
            graph.get(dep[1]).add(dep[0]);
        }
        Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
        for (int i = 0; i < numCourses; ++i) {
            visited.put(i, 0);
        }
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (!DFS(i, graph, visited, stack)) {
                int[] emptyArray = {};
                return emptyArray;
            }
        }
        int index = 0;
        while (!stack.isEmpty()) {
            rst[index++] = stack.pop();
        }
        return rst;
    }
    private boolean DFS(int node, List<List<Integer>> graph, Map<Integer, Integer> visited, Stack<Integer> stack) {
        if (visited.get(node) != 0) {
            return true;
        }
        visited.put(node, 1);
        for (int i : graph.get(node)) {
            if (visited.get(i) == 0) {
                DFS(i, graph, visited, stack);
            }
            if (visited.get(i) == 1) {
                return false;
            }
        }
        visited.put(node, 2);
        stack.push(node);
        return true;
    }
}