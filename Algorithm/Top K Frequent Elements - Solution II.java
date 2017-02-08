public class Solution {
    private class Node {
        int val;
        int freq;
        Node(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }
    private class NodeComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            if (a.freq == b.freq) {
                return a.val - b.val;
            } else {
                return a.freq - b.freq;
            }
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> rst = new ArrayList<Integer>();
        if (nums == null || nums.length == 0 || k == 0) {
            return rst;
        }
        Queue<Node> heap = new PriorityQueue<Node>(k, new NodeComparator());
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        int index = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (index++ < k) {
                heap.offer(new Node(key, value));
            } else {
                if (value > heap.peek().freq || (value == heap.peek().freq && key < heap.peek().val)) {
                    heap.poll();
                    heap.offer(new Node(key,value));
                }
            }
        }
        while (!heap.isEmpty()) {
            rst.add(heap.poll().val);
        }
        Collections.reverse(rst);
        return rst;
    }
}