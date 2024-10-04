/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode nodeBeforeMiddle = new ListNode(0, head);
        ListNode lastNode = head;

        while(lastNode != null && lastNode.next != null) {
            lastNode = lastNode.next.next;
            nodeBeforeMiddle = nodeBeforeMiddle.next;
        }

        if (head.equals(lastNode)) {
            return null;
        } else {
            nodeBeforeMiddle.next = nodeBeforeMiddle.next.next;
            return head;
        }
    }
}
