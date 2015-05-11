/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
        	return;
        }
        ListNode mid = findMid(head);
        ListNode right = reverse(mid.next);
        mid.next = null;
        merge(head, right);
    }
    private ListNode findMid(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	ListNode slow = head;
    	ListNode fast = head;
    	while (fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return slow;
    }
    private ListNode reverse(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	ListNode cur = head;
    	ListNode prev = null;
    	while (cur != null) {
    		ListNode next = cur.next;
    		cur.next = prev;
    		prev = cur;
    		cur = next;
    	}
    	return prev;
    }
    private void merge(ListNode left, ListNode right) {
    	ListNode dummy = new ListNode(0);
    	ListNode tail = dummy;
    	boolean flag = true;
    	while (left != null && right != null) {
    		if (flag) {
    			tail.next = left;
    			left = left.next;
    		} else {
    			tail.next = right;
    			right = right.next;
    		}
    		tail = tail.next;
    		flag ^= true;
    	}
    	if (left != null) {
    		tail.next = left;
    	} else {
    		tail.next = right;
    	}
    }
}