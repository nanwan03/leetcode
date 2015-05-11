/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int length = getLength(head);
        if (length == 0 || k == 0) {
        	return head;
        }
        k %= length;
        if (k == 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode tail = head;
        while (tail.next != null) {
        	tail = tail.next;
        }
        for (int i = 0; i < length - k; i++) {
        	head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;
        tail.next = dummy.next;
        return newHead;
    }
    private int getLength(ListNode head) {
    	int length = 0;
    	while (head != null) {
    		length++;
    		head = head.next;
    	}
    	return length;
    }
}