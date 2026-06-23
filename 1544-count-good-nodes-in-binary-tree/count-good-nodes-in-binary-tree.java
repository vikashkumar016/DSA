/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count=0;
    public void count(TreeNode root,int max){
        if(root==null){
            return ;
        }
        int val=root.val;
        if(val>=max){
            count++;
        }     
        max=Math.max(max,val);
        count(root.left,max);
        count(root.right,max);

    }
    public int goodNodes(TreeNode root) {
         int val=root.val;
         count(root,val);
         return count;
    }
}