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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
        	return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
        	fast = fast.next;
        }
        ListNode slow = head;
        while (fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}