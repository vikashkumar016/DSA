/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode>set= new HashSet<>();
        ListNode temp1=headA;
        while(temp1!=null){
            set.add(temp1);
            temp1=temp1.next;
        }
        temp1=headB;
        while(temp1!=null){
            if(set.contains(temp1)){
                return temp1;
            }
            temp1=temp1.next;
        }
        return null;
    }
}