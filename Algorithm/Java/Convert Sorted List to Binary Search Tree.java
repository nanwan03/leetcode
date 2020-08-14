/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    private ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        int length = getLength(head);
        if (length == 0) {
            return null;
        }
        cur = head;
        return buildTree(length);
    }
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
    private TreeNode buildTree(int size) {
        if (size == 0) {
            return null;
        }
        TreeNode left = buildTree(size / 2);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = buildTree(size - 1 - size / 2);
        root.left = left;
        root.right = right;
        return root;
    }
}