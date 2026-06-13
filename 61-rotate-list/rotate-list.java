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
    public ListNode rotateRight(ListNode head, int k) {
if (head == null || head.next == null || k == 0) return head;

        // Step 1: find length
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        k = k % length;
        if (k == 0) return head;

        // Step 2: move fast pointer k steps ahead
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        // Step 3: move both pointers
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Step 4: rearrange links
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }
}