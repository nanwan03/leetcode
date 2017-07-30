public class Solution {
    private int index = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] rst = new int[numCourses];
        index = numCourses - 1;
        if (numCourses == 0 || prerequisites == null) {
            return rst;
        }
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] edge : prerequisites) {
            adjList.get(edge[1]).add(edge[0]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (visited[i] == 0) {
                if (!DFS(i, adjList, visited, rst)) {
                    return new int[0];
                }
            }
        }
        return rst;
    }
    private boolean DFS(int node, List<List<Integer>> adjList, int[] visited, int[] rst) {
        visited[node] = 1;
        for (int i : adjList.get(node)) {
            if (visited[i] == 0) {
                DFS(i, adjList, visited, rst);
            }
            if (visited[i] == 1) {
                return false;
            }
        }
        visited[node] = 2;
        rst[index--] = node;
        return true;
    }
}