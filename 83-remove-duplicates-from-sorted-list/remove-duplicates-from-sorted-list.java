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
    public ListNode deleteDuplicates(ListNode head) {
        //  ListNode current = head;

        // while (current != null && current.next != null) {
        //     if (current.val == current.next.val) {
        //         // skip the duplicate node
        //         current.next = current.next.next;
        //     } else {
        //         // move to the next node
        //         current = current.next;
        //     }
        // }

        // return head;
       
       ListNode curr = head;

        while (curr != null) {
            ListNode runner = curr;
            while (runner.next != null) {
                if (runner.next.val == curr.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            curr = curr.next;
        }
        return head;


    }
}