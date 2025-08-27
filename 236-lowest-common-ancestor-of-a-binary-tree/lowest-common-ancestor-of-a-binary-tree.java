/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively find LCA in the left subtree
        TreeNode leftLca = lowestCommonAncestor(root.left, p, q);
        
        // Recursively find LCA in the right subtree
        TreeNode rightLca = lowestCommonAncestor(root.right, p, q);

        // If both left and right LCA are non-null, root is the LCA
        if (leftLca != null && rightLca != null) {
            return root;
        }

        // Otherwise, return the non-null LCA (either left or right)
        return leftLca != null ? leftLca : rightLca;
    }
    }
