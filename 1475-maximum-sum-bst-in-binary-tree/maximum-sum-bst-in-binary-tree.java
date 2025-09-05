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

    private static class Info {
        boolean isBST;
        int sum;
        int min;
        int max;

        Info(boolean isBST, int sum, int min, int max) {
            this.isBST = isBST;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private Info helper(TreeNode root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = helper(root.left);
        Info right = helper(root.right);

        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            int sum = root.val + left.sum + right.sum;
            maxSum = Math.max(maxSum, sum);
            int min = Math.min(root.val, left.min);
            int max = Math.max(root.val, right.max);
            return new Info(true, sum, min, max);
        }

        return new Info(false, 0, 0, 0); // Not a BST
    }
}
