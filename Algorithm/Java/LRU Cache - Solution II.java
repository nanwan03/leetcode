public class LRUCache {
    private int size;
    private Map<Integer, Integer> cache;
    public LRUCache(int capacity) {
        this.size = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        int val = cache.remove(key);
        cache.put(key, val); 
        return val;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            cache.remove(key);
        }
        if(cache.size()==size) {
            cache.remove(cache.entrySet().iterator().next().getKey());
        }
        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */