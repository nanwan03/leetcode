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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int rst = 0;
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) {
                rst += root.left.val;
            } else {
                rst += sumOfLeftLeaves(root.left);
            }
        }
        rst += sumOfLeftLeaves(root.right);
        return rst;
    }
}