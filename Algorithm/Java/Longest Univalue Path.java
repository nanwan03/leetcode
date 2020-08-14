/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int rst = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return rst;
    }
    private int helper(TreeNode node) {
        int left = node.left != null ? helper(node.left) : 0;
        int right = node.right != null ? helper(node.right) : 0;
        left = node.left != null && node.left.val == node.val ? left + 1 : 0;
        right = node.right != null && node.right.val == node.val ? right + 1 : 0;
        rst = Math.max(rst, left + right);
        return Math.max(left, right);
    }
}