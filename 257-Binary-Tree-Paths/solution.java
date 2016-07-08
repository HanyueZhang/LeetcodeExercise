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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        subPathHelper(root, list, "");
        return list;
    }
    
    private void subPathHelper(TreeNode node, List<String> list, String path) {
       if(node.left == null && node.right == null) {
           list.add(path + node.val);
       }
       if(node.right != null) {
           subPathHelper(node.right, list, path + node.val + "->");
       }
       if(node.left != null) {
           subPathHelper(node.left, list, path + node.val + "->");
       }
    }
}