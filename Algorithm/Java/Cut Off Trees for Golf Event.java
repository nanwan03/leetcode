class Solution {
    private class Node implements Comparable<Node> {
        int val;
        int x;
        int y;
        Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
        public int compareTo(Node a) {
            return this.val - a.val;
        }
    }
    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) {
            return 0;
        }
        Queue<Node> heap = new PriorityQueue<Node>();
        int row = forest.size();
        int col = forest.get(0).size();
        for (int i = 0; i < row; ++i) {
            for (int j = 0;  j < col; ++j) {
                if (forest.get(i).get(j) > 1) {
                    heap.offer(new Node(forest.get(i).get(j), i, j));
                }
            }
        }
        int rst = 0;
        int startX = 0;
        int startY = 0;
        while (!heap.isEmpty()) {
            Node node = heap.poll();
            int step = BFS(forest, node.x, node.y, startX, startY, row, col);
            if (step == -1) {
                return -1;
            }
            rst += step;
            startX = node.x;
            startY = node.y;
        }
        return rst;
    }
    private int BFS(List<List<Integer>> forest, int targetX, int targetY, int startX, int startY, int row, int col) {
        int step = 0;
        Queue<Node> queue = new LinkedList<Node>();
        boolean[][] visited = new boolean[row][col];
        Node start = new Node(forest.get(startX).get(startY), startX, startY);
        queue.offer(start);
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node node = queue.poll();
                if (node.x == targetX && node.y == targetY) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int nx = node.x + dir[0];
                    int ny = node.y + dir[1];
                    if (nx < 0 || nx >= row || ny < 0 | ny >= col || forest.get(nx).get(ny) == 0) {
                        continue;
                    }
                    Node next = new Node(forest.get(nx).get(ny), nx, ny);
                    if(!visited[nx][ny]) {
                        queue.offer(next);
                        visited[nx][ny] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}