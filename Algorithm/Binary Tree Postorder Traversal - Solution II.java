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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        stack.push(root);
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            if (temp != null) {
                rst.add(temp.val);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        Collections.reverse(rst);
        return rst;
    }
}