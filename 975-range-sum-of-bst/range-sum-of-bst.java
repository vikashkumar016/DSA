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
    public int rangeSumBST(TreeNode root, int low, int high) {
        // Base case: if root is null, return 0
        if (root == null) {
            return 0;
        }

        // Initialize the sum to 0
        int sum = 0;

        // If root's value is within the range, include it in the sum
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        // If root's value is greater than low, we can explore the left subtree
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }

        // If root's value is less than high, we can explore the right subtree
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }

        // Return the total sum
        return sum;
    }
}
