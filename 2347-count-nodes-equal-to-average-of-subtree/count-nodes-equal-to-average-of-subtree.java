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
    int answer=0;
    public int averageOfSubtree(TreeNode root) {
         dfs(root);
        return answer;
    }
    private int[] dfs(TreeNode root){
        if(root==null){
            return new int[]{ 0,0};
        }
           int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int sum = root.val + left[0] + right[0];

        int count = 1 + left[1] + right[1];

        int average = sum / count;

        if (average == root.val) {
            answer++;
        }

        return new int[]{sum, count};
    }
}