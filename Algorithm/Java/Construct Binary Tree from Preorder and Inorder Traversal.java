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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }
        return buildBST(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }
    private TreeNode buildBST(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }
        int k = findK(inorder, inStart, inEnd, preorder[preStart]);
        if (k == -1) {
            return null;
        }
        int leftLength = k - inStart;
        int rightLength = inEnd - k;
        TreeNode root = new TreeNode(inorder[k]);
        root.left = buildBST(inorder, inStart, k - 1, preorder, preStart + 1, preStart + leftLength);
        root.right = buildBST(inorder, k + 1, inEnd, preorder, preEnd + 1 - rightLength, preEnd);
        return root;
    }
    private int findK(int[] A, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (A[i] == target) {
                return i;
            }
        }
        return -1;
    }
}