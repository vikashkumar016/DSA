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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k = 0;
        ListNode temp = head;

    
        while (temp != null) {
            k++;
            temp = temp.next;
        }

       
        if (n == k) {
            return head.next;
        }

       
        ListNode curr = head;
        for (int i = 0; i < k - n - 1; i++) {
            curr = curr.next;
        }

       
        curr.next = curr.next.next;

        return head;
    }
}