/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    if (!root) {
        return [];
    }

    const queue = [root];
    const rst = [];
    while (queue.length) {
        const size = queue.length;
        const cur = [];
        for (let i = 0; i < size; ++i) {
            node = queue.shift();
            cur.push(node.val);
            if (node.left) {
                queue.push(node.left);
            }
            if (node.right) {
                queue.push(node.right);
            }
        }
        rst.push(cur);
    }
    return rst;
};