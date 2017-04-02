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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<String>();
        if (root == null) {
            return rst;
        }
        List<Integer> path = new ArrayList<Integer>();
        helper(rst, path, root);
        return rst;
    }
    private void helper(List<String> rst, List<Integer> path, TreeNode root) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            rst.add(render(path));
        } else {
            helper(rst, path, root.left);
            helper(rst, path, root.right);
        }
        path.remove(path.size() - 1);
    }
    private String render(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        sb.append(path.get(0));
        for (int i = 1; i < path.size(); ++i) {
            sb.append("->").append(path.get(i));
        }
        return sb.toString();
    }
}