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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1,
                        postorder, 0, postorder.length - 1);
    }
    private TreeNode buildTree(int[] inorder, int inStart, int inEnd,
                                int[] postorder, int pStart, int pEnd) {
        if (inStart > inEnd || pStart > pEnd) {
            return null;
        }
        int k = findK(inorder, inStart, inEnd, postorder[pEnd]);
        if (k == -1) {
            return null;
        }
        int leftLength = k - inStart;
        int rightLength = inEnd - k;
        TreeNode root = new TreeNode(inorder[k]);
        root.left = buildTree(inorder, inStart, k - 1, postorder, pStart, pStart + leftLength - 1);
        root.right = buildTree(inorder, k + 1, inEnd, postorder, pEnd - rightLength, pEnd - 1);
        return root;
    }
    private int findK(int[] A, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if(A[i] == target) {
                return i;
            }
        }
        return -1;
    }
}