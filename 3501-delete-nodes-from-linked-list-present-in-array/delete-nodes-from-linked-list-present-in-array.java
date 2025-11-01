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
    public ListNode modifiedList(int[] nums, ListNode head) {
         
      
      // Step 1: Store all nums in a HashSet for fast lookup
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

      
        // Step 2: Create a dummy node to handle edge cases easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;

           // Step 3: Traverse the list and skip nodes whose values are in the set
        ListNode current = dummy;
        while (current.next != null) {
            if (set.contains(current.next.val)) {
                // Skip this node
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        // Step 4: Return the new head
        return dummy.next;
    }
}