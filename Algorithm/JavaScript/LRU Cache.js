var Node = function(key, value) {
    this.key = key;
    this.value = value;
    this.prev = null;
    this.next = null;
}
/**
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
    this.capacity = capacity;
    this.head = new Node(-1, -1);
    this.tail = new Node(-1, -1);
    this.head.next = this.tail;
    this.tail.prev = this.head;

    this.map = {};
};

/**
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
    if (!this.map[key]) {
        return -1;
    }
    const node = this.map[key];
    node.next.prev = node.prev;
    node.prev.next = node.next;
    this.moveToTail(node);
    return node.value;
};

/**
 * @param {number} key
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
    if (this.get(key) != -1) {
        this.map[key].value = value;
        return;
    }
    if (this.capacity === Object.keys(this.map).length) {
        if (this.capacity === 0) {
            return;
        }
        const lastKey = this.head.next.key;
        delete this.map[lastKey];
        this.head.next = this.head.next.next;
        this.head.next.prev = this.head;
    }
    const insertNode = new Node(key, value);
    this.moveToTail(insertNode);
    this.map[key] = insertNode;
};

LRUCache.prototype.moveToTail = function(node) {
    node.next = this.tail;
    node.prev = this.tail.prev;
    node.next.prev = node;
    node.prev.next = node;
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */