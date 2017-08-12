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
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> rst = new LinkedList<List<String>>();
        if (root == null) {
            return rst;
        }
        int level = getLevel(root);
        int size = (int) (Math.pow(2, level) - 1);
        List<String> items = new ArrayList<String>();
        for(int i = 0; i < size; ++i)  {
            items.add("");
        }
        for(int i = 0; i < level; ++i) {
            rst.add(new ArrayList<String>(items));
        }
        helper(root, rst, 0, level, 0, size - 1);
        return rst;
    }
    public void helper(TreeNode root, List<List<String>> rst, int index, int levels, int left, int right) {
        if (index == levels || root == null) {
            return;
        }
        int mid = left + (right - left) / 2;
        rst.get(index).set(mid, Integer.toString(root.val));
        helper(root.left, rst, index + 1, levels, left, mid - 1);
        helper(root.right, rst, index + 1, levels, mid + 1, right);
    }

    public int getLevel(TreeNode root) {
         if (root == null) {
             return 0;
         }
         return 1 + Math.max(getLevel(root.left), getLevel(root.right));
    }
}