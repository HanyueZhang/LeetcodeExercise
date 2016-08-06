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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false;
        }
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        return left && right;
    }
    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
    
    
    
    
    
    
    // public boolean isBalanced(TreeNode root) {
    //     if(root == null) return true;
    //     if(root.left == null && root.right == null) return true; 
    //     if(Math.abs(depth(root.left) - depth(root.right)) > 1) return false;
    //     return isBalanced(root.left)&&isBalanced(root.right); //"..depth of the two subtrees of [every node] never differ... "
    // }
    // private int depth(TreeNode node) {
    //     if(node == null) return 0;
    //     return Math.max(depth(node.left), depth(node.right)) + 1;
    // }
}