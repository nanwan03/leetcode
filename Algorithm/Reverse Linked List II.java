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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode cur = head;
        ListNode prevM = null;
        ListNode nodeM = null;
        ListNode prev = null;
        for (int i = 0; i <= n; i++) {
            if (i < m) {
                if (i == m - 1) {
                    prevM = cur;
                    nodeM = cur.next;
                }
                cur = cur.next;
            } else {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
        }
        prevM.next = prev;
        nodeM.next = cur;
        return dummy.next;
    }
}