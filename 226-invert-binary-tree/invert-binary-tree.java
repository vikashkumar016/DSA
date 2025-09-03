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
    public TreeNode invertTree(TreeNode root) {
    //     if(root==null){
    //         return null;
    //     }
    //  TreeNode lst=invertTree(root.left);
    //  TreeNode rst =invertTree(root.right);
    //  root.left=rst;
    //  root.right=lst;
    //  return root;   

     if(root==null){
            return root;
        }
        
        TreeNode aux = root.right;
        root.right = root.left;
        root.left = aux;

        if (root.left!=null){
            invertTree(root.left);
        } 
        if (root.right!=null){
            invertTree(root.right);
        }  
        System.out.println(root.val);
        return root;
    }
}