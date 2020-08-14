/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
        	return;
        }
        TreeLinkNode parent = root;
        while (parent != null) {
        	TreeLinkNode next = null;
        	TreeLinkNode prev = null;
        	while (parent != null) {
        		if (next == null) {
        			next = parent.left != null ? parent.left : parent.right;
        		}
        		if (parent.left != null) {
        			if (prev == null) {
        				prev = parent.left;
        			} else {
        				prev.next = parent.left;
        				prev = prev.next;
        			}
        		}
        		if (parent.right != null) {
        			if (prev == null) {
        				prev = parent.right;
        			} else {
        				prev.next = parent.right;
        				prev = prev.next;
        			}
        		}
        		parent = parent.next;
        	}
        	parent = next;
        }
    }
}