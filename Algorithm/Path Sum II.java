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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (root == null) {
            return rst;
        }
        List<Integer> items = new ArrayList<Integer>();
        helper(rst, items, root, sum);
        return rst;
    }
    private void helper(List<List<Integer>> rst, List<Integer> items, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        items.add(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            rst.add(new ArrayList<Integer>(items));
        } else {
            helper(rst, items, root.left, sum);
            helper(rst, items, root.right, sum);
        }
        items.remove(items.size() - 1);
    }
}