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
         if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        // Traverse the list with slow and fast pointers
        while (fast != null && fast.next != null) {
            fast = fast.next.next;  // Move fast pointer two steps
            prev = slow;            // Keep track of the previous node
            slow = slow.next;       // Move slow pointer one step
        }
        
        // Remove the middle node
        prev.next = slow.next;
        
        return head;  // Return the modified list
    }
}