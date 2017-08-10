public class AllOne {
    private class Node {
        int value;
        Set<String> keySet = new HashSet<String>();
        Node next;
        Node pre;
        public Node(int value) {
            this.value = value;
        }
    }
    private Node head = new Node(-1);
    private Node tail = new Node(-1);
    private Map<Integer, Node> nodeMap = new HashMap<Integer, Node>();
    private Map<String, Integer> valueMap = new HashMap<String, Integer>();
    /** Initialize your data structure here. */
    public AllOne() {
        head.next = tail;
        tail.pre = head;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (valueMap.containsKey(key)) {
            changeKey(key, 1);
        } else {
        	valueMap.put(key, 1);
            if (head.next.value != 1) {
                addNode(new Node(1), head);
            }
            head.next.keySet.add(key);
            nodeMap.put(1, head.next);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (valueMap.containsKey(key)) {
            int count = valueMap.get(key);
            if (count == 1) {
                valueMap.remove(key);
                Node temp = nodeMap.get(count);
                temp.keySet.remove(key);
                if (temp.keySet.size() == 0) {
                    removeNode(temp);
                    nodeMap.remove(temp.value);
                }
            } else {
                changeKey(key, -1);
            }
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.pre == head ? "" : (String) tail.pre.keySet.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail ? "" : (String) head.next.keySet.iterator().next(); 
    }
    
    private void changeKey(String key, int offset) {
        int count = valueMap.get(key);
        valueMap.put(key, count + offset);
        Node cur = nodeMap.get(count);
        if (nodeMap.containsKey(count + offset)) {
        	nodeMap.get(count + offset).keySet.add(key);
        } else {
        	Node newNode = new Node(count + offset);
            newNode.keySet.add(key);
            nodeMap.put(count + offset, newNode);
            addNode(newNode, offset == 1 ? cur : cur.pre);
        }
        cur.keySet.remove(key);
        if (cur.keySet.size() == 0) {
            removeNode(cur);
            nodeMap.remove(cur.value);
        }
    }
    
    private void removeNode(Node node) {
    	node.pre.next = node.next;
    	node.next.pre = node.pre;
    	node.next = null;
    	node.pre = null;
    }
    
    private void addNode(Node newNode, Node preNode) {
    	newNode.pre = preNode;
    	newNode.next = preNode.next;
    	preNode.next.pre = newNode;
    	preNode.next = newNode;
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