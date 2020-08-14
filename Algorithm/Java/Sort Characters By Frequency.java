class Solution {
    private static class Node implements Comparable<Node> {
        public char c;
        public int val;
        Node(char c, int val) {
            this.c = c;
            this.val = val;
        }
        public int compareTo(Node a) {
            return this.val == a.val ? this.c - a.c : a.val - this.val;
        }
    }
    public String frequencySort(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Queue<Node> heap = new PriorityQueue<Node>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int val = entry.getValue();
            Node n = new Node(c, val);
            heap.offer(n);
        }
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            Node n = heap.poll();
            while(n.val-- > 0) {
                sb.append(n.c);
            }
        }
        return sb.toString();
    }
}