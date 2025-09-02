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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        dfs(root, path, result);
        return result;
    }
    
    private void dfs(TreeNode root, List<Integer> path, List<String> result) {
        if (root == null) {
            return;
        }
        
        // Add the current node's value to the path
        path.add(root.val);
        
        // If it's a leaf node, add the path to the result
        if (root.left == null && root.right == null) {
            result.add(buildPath(path));
        } else {
            // Recur for left and right children
            dfs(root.left, path, result);
            dfs(root.right, path, result);
        }
        
        // Backtrack: remove the current node from the path
        path.remove(path.size() - 1);
    }
    
    // Helper function to convert path list to string
    private String buildPath(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i < path.size() - 1) {
                sb.append("->");
            }
        }
        return sb.toString();
    }
}
