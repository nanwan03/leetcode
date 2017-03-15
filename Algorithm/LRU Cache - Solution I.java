public class LRUCache {
    private class Node {
    	int key;
    	int value;
    	Node next;
    	Node prev;
    	public Node(int key, int value) {
    		this.key = key;
    		this.value = value;
    		this.next = null;
    		this.prev = null;
    	}
    }
    
    private Map<Integer, Node> map = new HashMap<Integer, Node>();
    private int capacity;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    
    public LRUCache(int capacity) {
    	this.capacity = capacity;
    	head.next = tail;
    	tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
        	return -1;
        }
        Node node = map.get(key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
        moveToTail(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (get(key) != -1) {
        	map.get(key).value = value;
        	return;
        }
        if (map.size() == this.capacity) {
        	map.remove(head.next.key);
        	head.next = head.next.next;
        	head.next.prev = head;
        }
        Node insert = new Node(key, value);
        map.put(key, insert);
        moveToTail(insert);
    }
    
    private void moveToTail(Node node) {
    	node.next = tail;
    	node.prev = tail.prev;
    	node.next.prev = node;
    	node.prev.next = node;
    }
}