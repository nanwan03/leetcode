public class Solution {
    private class Node implements Comparable<Node> {
        int x;
        int y;
        int value;
        Node (int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
        public int compareTo(Node node) {
            return this.value - node.value;
        }
    }
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0) {
            return 0;
        }
        int row = heightMap.length;
        int col = heightMap[0].length;
        Queue<Node> heap = new PriorityQueue<Node>();
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
                    visited[i][j] = true;
                    heap.offer(new Node(i, j, heightMap[i][j]));
                }
            }
        }
        
        int rst = 0;
        int max = Integer.MIN_VALUE;
        while (!heap.isEmpty()) {
            Node node = heap.poll();
            max = Math.max(max, node.value);
            List<Node> neighbors = getNeighbor(node, row, col, heightMap, visited);
            for (Node neighbor : neighbors) {
                heap.offer(neighbor);
                if (heightMap[neighbor.x][neighbor.y] < max) {
                    rst += max - heightMap[neighbor.x][neighbor.y];
                }
            }
        }
        return rst;
    }
    private List<Node> getNeighbor(Node node, int row, int col, int[][] heightMap, boolean[][] visited) {
        int x = node.x;
        int y = node.y;
        List<Node> rst = new ArrayList<Node>();
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX < 0 || newX >= row || newY < 0 || newY >= col || visited[newX][newY]) {
                continue;
            }
            visited[newX][newY] = true;
            rst.add(new Node(newX, newY, heightMap[newX][newY]));
        }
        return rst;
    }
}