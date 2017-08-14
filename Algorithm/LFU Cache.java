public class LFUCache {
    private class Node {
        int freq;
        Set<Integer> keys = new LinkedHashSet<Integer>();
        Node prev;
        Node next;
        Node(Node prev, Node next, int freq, int key) {
            this.prev = prev;
            this.next = next;
            this.freq = freq;
            this.keys.add(key);
        }
    }
    private int capacity;
    private Node head = new Node(null, null, 0, -1);
    private Node tail = new Node(null, null, 0, -1);
    private Map<Integer, Integer> valueMap = new HashMap<Integer, Integer>();
    private Map<Integer, Node> nodeMap = new HashMap<Integer, Node>();
    public LFUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!valueMap.containsKey(key)) {
            return -1;
        }
        Node node = nodeMap.get(key);
        addNode(node, node.next, node.freq + 1, key);
        removeKey(key, node);
        return valueMap.get(key);
    }
    
    public void put(int key, int value) {
        if (get(key) == -1) {
            if (valueMap.size() == capacity) {
                if (head.next == tail) {
                    return;
                }
                int oldest = head.next.keys.iterator().next();
                valueMap.remove(oldest);
                nodeMap.remove(oldest);
                removeKey(oldest, head.next);
            }
            addNode(head, head.next, 1, key);
        }
        valueMap.put(key, value);
    }
    private void addNode(Node prev, Node next, int freq, int key) {
        if (next.freq == prev.freq + 1) {
            next.keys.add(key);
        } else {
            Node insert = new Node(prev, next, freq, key);
            insert.next.prev = insert;
            insert.prev.next = insert;
        }
        nodeMap.put(key, prev.next);
    }
    private void removeKey(int key, Node node) {
        node.keys.remove(key);
        if (node.keys.isEmpty()) {
            node.next.prev = node.prev;
            node.prev.next = node.next;   
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */