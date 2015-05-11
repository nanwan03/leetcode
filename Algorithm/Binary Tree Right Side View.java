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
    private int level = 0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        helper(root, rst, 0);
        return rst;
    }
    private void helper(TreeNode root, List<Integer> rst, int curLevel) {
        if (root == null) {
            return;
        }
        if (curLevel == level) {
            rst.add(root.val);
            level++;
        }
        helper(root.right, rst, curLevel + 1);
        helper(root.left, rst, curLevel + 1);
    }
}