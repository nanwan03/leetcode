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
    private class ResultType {
        int notSteal;
        int steal;
        ResultType(int notSteal, int steal) {
            this.notSteal = notSteal;
            this.steal = steal;
        }
    }
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ResultType rs = helper(root);
        return Math.max(rs.notSteal, rs.steal);
    }
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int notSteal = Math.max(left.notSteal, left.steal) + Math.max(right.notSteal, right.steal);
        int steal = left.notSteal + right.notSteal + root.val;
        return new ResultType(notSteal, steal);
    }
}