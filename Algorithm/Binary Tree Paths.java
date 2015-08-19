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
        List<Integer> nums = new ArrayList<Integer>();
        helper(rst, nums, root);
        return rst;
    }
    private static void helper(List<String> rst, List<Integer> nums, TreeNode root) {
        if (root == null) {
            return;
        }
        nums.add(root.val);
        if (root.left == null && root.right == null) {
        	StringBuilder sb = new StringBuilder();
        	for (int i : nums) {
        		sb.append(i).append("->");
        	}
        	sb.delete(sb.length() - 2, sb.length());
        	rst.add(sb.toString());
        	nums.remove(nums.size() - 1);
        	return;
        }
        if (root.left != null) {
        	helper(rst, nums, root.left);
        }
        if (root.right != null) {
        	helper(rst, nums, root.right);
        }
        nums.remove(nums.size() - 1);
    }
}