class MapSum {
     private class Node {
        Node[] next;
        boolean isEnd;
        int count = 0;
        int sum = 0;
        Node() {
            next = new Node[26];
            isEnd = false;
        }
        public int insert(String key, int val, int index) {
            if (index == key.length()) {
                int diff = val - this.count;
                this.count = val;
                this.sum += diff;
                this.isEnd = true;
                return diff;
            } else {
                if (this.next[key.charAt(index) - 'a'] == null) {
                    this.next[key.charAt(index) - 'a'] = new Node();
                }
                int sum = this.next[key.charAt(index) - 'a'].insert(key, val, index + 1);
                this.sum += sum;
                return sum;
            }
        }
        public int search(String prefix, int index) {
            if (index == prefix.length()) {
                return this.sum;
            }
            if (this.next[prefix.charAt(index) - 'a'] == null) {
            	return 0;
            }
            return this.next[prefix.charAt(index) - 'a'].search(prefix, index + 1);
        }
    }
    /** Initialize your data structure here. */
    Node root = new Node();
    public MapSum() {
        
    }
    
    public void insert(String key, int val) {
        root.insert(key, val, 0);
    }
    
    public int sum(String prefix) {
        return root.search(prefix, 0);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */