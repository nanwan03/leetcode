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
    public int rob(TreeNode root) {
        int[] result = findMax(root);
        return Math.max(result[0], result[1]);
    }

    // returns int[2] result. 
    // result[0] -- max value robbing current root; result[1] -- max value without robbing current root.
    private int[] findMax(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] left = findMax(root.left);
        int[] right = findMax(root.right);
        int result0 = root.val + left[1] + right[1];  // rob current root
        int result1 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);  // not rob current root
        return new int[] {result0, result1};
    }
}