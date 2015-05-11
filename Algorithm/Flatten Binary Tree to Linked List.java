/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root, null);
    }
    private TreeNode flatten(TreeNode root, TreeNode prevTail) {
        if (prevTail != null) {
            prevTail.left = null;
            prevTail.right = root;
        }
        prevTail = root;
        TreeNode right = root.right;
        if (root.left != null) {
            prevTail = flatten(root.left, prevTail);
        }
        if (right != null) {
            prevTail = flatten(right, prevTail);
        }
        return prevTail;
    }
}