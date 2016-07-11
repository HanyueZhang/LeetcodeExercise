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
    public boolean isValidBST(TreeNode root) {
        //1
        // if(root.left == null ) {
        //     return true;
        // }
        // if (root.left.val >= root.val) {
        //     return false;
        // }
        // if(root.right.val <= root.val) {
        //     return false;
        // }
        // return isValidBST(root.left) && isValidBST(root.right);
        
        //2
        // if(root == null) {
        //     return true;
        // }
        // if(root.left == null && root.right == null) {
        //     return true;
        // }
        // if(root.left == null) {
        //     if(root.val >= root.right.val) {
        //         return false;
        //     }
        //     return isValidBST(root.left);
        // }
        // if(root.right == null) {
        //     if(root.val <= root.left.val) {
        //         return false;
        //     }
        //     return isValidBST(root.right);
        // }
        // if(root.left != null && root.right != null) {
        //     if(root.left.val >= root.val) {
        //         return false;
        //     }
        //     if(root.right.val <= root.val) {
        //         return false;
        //     }
        //     return isValidBST(root.left) && isValidBST(root.right);
        // }
        // return false;
        return validHelper(root, null, null);
    }
    
    private boolean validHelper(TreeNode root, Integer min, Integer max) { // null cannot convert to int , so use Integer
        if(root == null) {
            return true;
        }
        if(min != null && min >= root.val) {
            return false;
        }
        if(max != null && max <= root.val) {
            return false;
        }
        return validHelper(root.left, min, root.val) && validHelper(root.right, root.val, max);
    }
}