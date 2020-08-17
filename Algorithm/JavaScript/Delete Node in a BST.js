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
 * @param {number} key
 * @return {TreeNode}
 */
var deleteNode = function(root, key) {
    if (root == null) {  //equals to (root === undefined || root === null)
        return root;
    }
    if (key < root.val) {
        root.left = deleteNode(root.left, key);
        return root;
    } else if (root.val < key) {
        root.right = deleteNode(root.right, key);
        return root;
    } else if (root.left === null) {
        return root.right;
    } else if (root.right === null) {
        return root.left;
    } else if (root.right.left === null) {
        root.right.left = root.left;
        return root.right;
    } else {
        const smallest = find(root.right);
        smallest.left = root.left;
        smallest.right = root.right;
        return smallest;
    }
};

function find (root) {
    while(root.left.left != null) {
        root = root.left;
    }
    const smallest = root.left;
    root.left = smallest.right;
    return smallest;
}