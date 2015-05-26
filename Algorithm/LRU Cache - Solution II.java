import java.util.*;
public class LRUCache {
    /**
     * HashMap makes absolutely no guarantees about the iteration order. 
     *    It can (and will) even change completely when new elements are added.
     * TreeMap will iterate according to the "natural ordering" of the keys according to their compareTo() method (or an externally supplied Comparator). 
     *  Additionally, it implements the SortedMap interface, which contains methods that depend on this sort order.
     * LinkedHashMap will iterate in the order in which the entries were put into the map
     * 
     */
    int size;
    LinkedHashMap<Integer, Integer> cache;
    public LRUCache(int capacity) {
        size = capacity;
        cache = new LinkedHashMap<Integer, Integer>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        int val = cache.remove(key);
        cache.put(key, val); // the feature of linkedhashmap
        return val;
    }
    
    public void set(int key, int value) {
        if(cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
            return;
        }
        if(cache.size()==size) { // find the least visited entry and remove
            cache.remove(cache.entrySet().iterator().next().getKey());
        }
        cache.put(key, value);
    }
}