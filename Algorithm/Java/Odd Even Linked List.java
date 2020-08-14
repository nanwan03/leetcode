/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode even = head.next;
        ListNode dummy = even;
        while (even != null && even.next != null) {
            cur.next = cur.next.next;
            even.next = even.next.next;
            cur = cur.next;
            even = even.next;
        }
        cur.next = dummy;
        return head;
    }
}