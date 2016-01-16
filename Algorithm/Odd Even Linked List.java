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
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (cur != null && cur.next != null) {
            ListNode evenNode = cur.next;
            cur.next = evenNode.next;
            evenNode.next = null;
            dummy.next = evenNode;
            if (cur.next != null) {
                cur = cur.next;
            }
            dummy = dummy.next;
        }
        cur.next = tail.next;
        return head;
    }
}