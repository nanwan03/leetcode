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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return l1;
        }
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val + carry;
            carry = temp / 10;
            temp = temp % 10;
            tail.next = new ListNode(temp);
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode newHead = l1 != null ? l1 : l2;
        while (newHead != null) {
            int temp = newHead.val + carry;
            carry = temp / 10;
            temp = temp % 10;
            tail.next = new ListNode(temp);
            tail = tail.next;
            newHead = newHead.next;
        }
        if (carry == 1) {
            tail.next = new ListNode(1);
        }
        return dummy.next;
    }
}