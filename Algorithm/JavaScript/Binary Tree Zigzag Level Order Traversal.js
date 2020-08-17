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
var zigzagLevelOrder = function(root) {
    if (!root) {
        return [];
    }

    const queue = [root];
    const rst = [];
    let flag = true;
    while (queue.length) {
        const size = queue.length;
        const cur = [];
        for (let i = 0; i < size; ++i) {
            const node = queue.shift();
            if (flag) {
                cur.push(node.val);
            } else {
                cur.unshift(node.val);
            }

            if(node.left) {
                queue.push(node.left);
            }
            if (node.right) {
                queue.push(node.right);
            }
        }
        rst.push(cur);
        flag = !flag;
    }
    return rst;
};