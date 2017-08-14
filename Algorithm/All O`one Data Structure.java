public class AllOne {
    private class Node {
        int freq;
        Node prev;
        Node next;
        Set<String> keys = new LinkedHashSet<String>();
        Node(Node prev, Node next, int freq, String key) {
            this.prev = prev;
            this.next = next;
            this.freq = freq;
            this.keys.add(key);
        }
    }
    private Node head = new Node(null, null, 0, "");
    private Node tail = new Node(null, null, 0, "");
    private Map<String, Node> nodeMap = new HashMap<String, Node>();
    /** Initialize your data structure here. */
    public AllOne() {
        head.next = tail;
        tail.prev = head;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Node node = nodeMap.containsKey(key) ? nodeMap.get(key) : head;
        addNode(node, node.next, node.freq + 1, key);
        if (node != head) {
            removeKey(key, node);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            if (node.freq == 1) {
                nodeMap.remove(key);
            } else {
                addNode(node.prev, node, node.freq - 1, key);
            }
            removeKey(key, node);
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }
    private void addNode(Node prev, Node next, int freq, String key) {
        if (prev.freq == freq) {
            prev.keys.add(key);
            nodeMap.put(key, prev);
        } else if (next.freq == freq) {
            next.keys.add(key);
            nodeMap.put(key, next);
        } else {
            Node insert = new Node(prev, next, freq, key);
            insert.next.prev = insert;
            insert.prev.next = insert;
            nodeMap.put(key, prev.next);
        }
    }
    private void removeKey(String key, Node node) {
        node.keys.remove(key);
        if (node.keys.isEmpty()) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }
    }
    
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */