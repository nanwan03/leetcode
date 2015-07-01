/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private static int cur = 0;
    private static int rst = 0;
    public int kthSmallest(TreeNode root, int k) {
        cur = k;
        helper(root);
        return rst;
    }
    private static void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (--cur == 0) {
            rst = root.val;
        }
        helper(root.right);
    }
}