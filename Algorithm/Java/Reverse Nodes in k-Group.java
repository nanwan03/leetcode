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
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = getLength(head);
        if (length == 0) {
            return head;
        }
        if (k == 0) {
            return head;
        }
        int groupNum = length / k;
        if (groupNum == 0) {
            return head;
        }
        ListNode cur = head;
        ListNode curTail = null;
        ListNode prevTail = null;
        ListNode curHead = null;
        for (int i = 0; i < groupNum; i++) {
            ListNode prev = null;
            for (int j = 0; j < k; j++) {
                if (j == 0) {
                    curTail = cur;
                }
                if (j == k - 1) {
                    curHead = cur;
                }
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            if (prevTail == null) {
                head = curHead;
            } else {
                prevTail.next = curHead;
            }
            prevTail = curTail;
        }
        curTail.next = cur;
        return head;
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