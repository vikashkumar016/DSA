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
    public int pairSum(ListNode head) {
     ListNode slow=head;
     ListNode fast=head;
     ListNode prev=null;
     while(fast!=null && fast.next!=null){
        fast=fast.next.next;
        ListNode temp = slow.next;
        slow.next=prev;
        prev=slow;
        slow=temp;
     }
     int ans=0;
     while(slow!=null){
         ans=Math.max(ans,prev.val+slow.val);
        slow=slow.next;
        prev=prev.next;
     }
      return ans;
    }
}