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
 * @return {number}
 */
var maxPathSum = function(root) {
    if (!root) {
        return 0;
    }

    const helper = (root) => {
        if (!root) {
            return [0, Number.NEGATIVE_INFINITY];
        }

        const left = helper(root.left);
        const right = helper(root.right);

        const singlePath = root.val + Math.max(left[0], right[0]);
        const maxPath = Math.max(Math.max(left[1], right[1]), left[0] + root.val + right[0]);

        return [Math.max(0, singlePath), maxPath];
    }

    return helper(root)[1];
};