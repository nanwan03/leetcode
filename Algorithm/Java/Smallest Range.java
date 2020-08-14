public class Solution {
    private class Node implements Comparable<Node> {
        int array;
        int index;
        int value;
        Node(int array, int index, int value) {
          this.array = array;
          this.index = index;
          this.value = value;
        }
        public int compareTo(Node a) {
          return this.value - a.value;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0) {
          return new int[2];
        }
        int[] rst = new int[2];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Queue<Node> heap = new PriorityQueue<Node>();
        for (int i = 0; i < nums.size(); ++i) {
          int value = nums.get(i).get(0);
          min = Math.min(value, min);
          max = Math.max(value, max);
          heap.offer(new Node(i, 0, value));
        }
        int minRST = min;
        int maxRST = max;
        while (!heap.isEmpty()) {
          Node node = heap.poll();
          int array = node.array;
          int index = node.index;
          if (index + 1 >= nums.get(array).size()) {
            break;
          }
          int nextValue = nums.get(array).get(index + 1);
          heap.offer(new Node(array, index + 1, nextValue));
          min = heap.peek().value;
          max = Math.max(max, nextValue);
          if (max - min < maxRST - minRST) {
            maxRST = max;
            minRST = min;
          }
        }
        rst[0] = minRST;
        rst[1] = maxRST;
        return rst;
    }
}