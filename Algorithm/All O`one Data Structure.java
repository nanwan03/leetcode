public class AllOne {
    private class Node {
        int value;
        Node prev;
        Node next;
        Set<String> keys = new HashSet<String>();
        Node(int value, String key) {
            this.value = value;
            this.prev = null;
            this.next = null;
            this.keys.add(key);
        }
    }
    private Node head = new Node(-1, "");
    private Node tail = new Node(-1, "");
    private Map<String, Integer> valueMap = new HashMap<String, Integer>();
    private Map<Integer, Node> nodeMap = new HashMap<Integer, Node>();
    /** Initialize your data structure here. */
    public AllOne() {
        head.next = tail;
        tail.prev = head;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (valueMap.containsKey(key)) {
            changeKey(key, 1);
        } else {
            valueMap.put(key, 1);
            if (head.next.value != 1) {
                addNode(new Node(1, key), head);
            } else {
                head.next.keys.add(key);
            }
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (valueMap.containsKey(key)) {
            int count = valueMap.get(key);
            if (count != 1) {
                changeKey(key, -1);
            } else {
                valueMap.remove(key);
                removeKey(key, nodeMap.get(count));
            }
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
    private void changeKey(String key, int offset) {
        int count = valueMap.get(key);
        int newV = count + offset;
        valueMap.put(key, newV);
        Node node = nodeMap.get(count);
        if (nodeMap.containsKey(newV)) {
            nodeMap.get(newV).keys.add(key);
        } else {
            addNode(new Node(newV, key), offset == 1 ? node : node.prev);
        }
        removeKey(key, node);
    }
    private void addNode(Node node, Node prevNode) {
        nodeMap.put(node.value, node);
        node.next = prevNode.next;
        node.prev = prevNode;
        prevNode.next.prev = node;
        prevNode.next = node;
    }
    private void removeKey(String key, Node node) {
        node.keys.remove(key);
        if (node.keys.isEmpty()) {
            nodeMap.remove(node.value);
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