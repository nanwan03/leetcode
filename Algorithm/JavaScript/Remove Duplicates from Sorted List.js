/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
    if (head == null || head.next == null) {
        return head;
    }
    const dummy = new ListNode(-1);
    dummy.next = head;
    head = dummy;

    while (head.next != null && head.next.next != null) {
        if (head.next.val === head.next.next.val) {
            head.next = head.next.next;
        } else {
            head = head.next;
        }
    }

    return dummy.next;
};