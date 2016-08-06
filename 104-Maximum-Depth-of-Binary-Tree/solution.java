/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
   
    public int maxDepth(TreeNode root) {
      int leftDepth = helper(root.left);
      int rightDepth = helper(root.right);
      return Math.max(leftDepth, rightDepth);
    }
    private int depth helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(helper(node.left), helper(node.right)) + 1;
    }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
    // public int maxDepth(TreeNode root) {
    //     if(root == null) return 0;
    //     return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    // }
}