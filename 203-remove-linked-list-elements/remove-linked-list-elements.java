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
    public ListNode removeElements(ListNode head, int val) {
          // Step 1: remove leading nodes with value val
        while (head != null && head.val == val) {
            head = head.next;
        }

        // Step 2: remove nodes in the rest of the list
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next; // skip the node
            } else {
                current = current.next; // move forward
            }
        }

        // Step 3: return the new head
        return head;
    }
}