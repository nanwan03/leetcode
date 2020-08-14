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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSum(root.left, sum) + pathSum(root.right, sum) + findPath(root, sum);
    }
    private int findPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        sum -= root.val;
     
        return (sum == 0 ? 1 : 0) + findPath(root.left, sum) + findPath(root.right, sum);
    }
}