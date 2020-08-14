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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hl = height(root.left);
        int hr = height(root.right);
        if (hl == hr) {
            return (int) Math.pow(2, hl) + countNodes(root.right);
        } else {
            return (int) Math.pow(2, hr) + countNodes(root.left);
        }
    }
    private int height(TreeNode root) {
        int count = 0;
        while (root != null) {
            root = root.left;
            count++;
        }
        return count;
    }
}