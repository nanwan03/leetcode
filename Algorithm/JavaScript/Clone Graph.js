/**
 * // Definition for a Node.
 * function Node(val, neighbors) {
 *    this.val = val === undefined ? 0 : val;
 *    this.neighbors = neighbors === undefined ? [] : neighbors;
 * };
 */

/**
 * @param {Node} node
 * @return {Node}
 */
var cloneGraph = function(node) {
    if (!node) {
        return node;
    }
    const map = {};

    const helper = (node) => {
        if (!node) {
            return null;
        }
        if (!map[node.val]) {
            map[node.val] = new Node(node.val);
            map[node.val].neighbors = node.neighbors.map(helper);
        }
        return map[node.val];
    }

    return helper(node);
};