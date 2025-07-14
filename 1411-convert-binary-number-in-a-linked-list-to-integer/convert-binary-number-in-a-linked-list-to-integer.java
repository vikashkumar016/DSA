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
    public int getDecimalValue(ListNode head) {
        List<Integer> bits = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            bits.add(current.val);
            current = current.next;
        }

        // Step 2: Convert binary to decimal
        int decimal = 0;
        int power = bits.size() - 1;
        for (int bit : bits) {
            decimal += bit * Math.pow(2, power);
            power--;
        }

        return decimal;
    }
}