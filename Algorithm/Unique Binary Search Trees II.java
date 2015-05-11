/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }
    private List<TreeNode> generate(int left, int right) {
        List<TreeNode> rst = new ArrayList<TreeNode>();
        if (left > right) {
            rst.add(null);
            return rst;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftL = generate(left, i - 1);
            List<TreeNode> rightL = generate(i + 1, right);
            for (TreeNode l : leftL) {
                for (TreeNode r : rightL) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    rst.add(root);
                }
            }
        }
        return rst;
    }
}