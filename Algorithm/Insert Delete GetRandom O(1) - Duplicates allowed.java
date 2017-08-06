public class RandomizedCollection {
    List<Integer> lists = new ArrayList<Integer>();
    Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
    Random r = new Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean rst = map.containsKey(val);
        if (!rst) {
            map.put(val, new HashSet<Integer>());
        }
        map.get(val).add(lists.size());
        lists.add(val);
        return !rst;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val).iterator().next();
        map.get(val).remove(index);
        if (index != lists.size() - 1) {
            int i = lists.get(lists.size() - 1);
            lists.set(index, i);
            map.get(i).remove(lists.size() - 1);
            map.get(i).add(index);
        }
        lists.remove(lists.size() - 1);
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return lists.get(r.nextInt(lists.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */