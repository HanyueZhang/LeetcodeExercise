/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //九章算法 第三节课
 // singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点
 // maxPath: 从树中任意到任意点的最大路径，这条路径至少包含一个点
 // 路径包括三种情况
 //  1. 整条最大路径都在root的左子树里面 -> left.maxPath
 //  2. 整条最大路径都在root的右子树里面 -> right.maxPath
 //  3. 最大路径经过root 从左子树到右子树 -> left.singlePath + right.singlePath + root.val
public class Solution {
    private class ResultType {
        
        int singlePath, maxPath;
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
    
    private ResultType helper(TreeNode root) {
        if(root == null) {
            return new ResultType(0, Integer.MIN_VALUE); 
            //由于规定singlePath可以不包含任何点所以当root为null -> singlePath == 0
            //由于maxPath最少包含一个点（题目要求），由于后面程序中用Math.max 为了避免这个null值返回的数据影响其他数据 -> maxPath == MIN_VALUE; (Math.min -> MAX_VALUE)
        }
        //divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        //conquer
        int singlePath = Math.max(left.singlePath, right.singlePath) +root.val;
        singlePath = Math.max(0, singlePath); //singlePath < 0的时候，我们抛弃这条路径 -> 当前点singlePath = 0；
        
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);
        
        return new ResultType(singlePath, maxPath);
        
    }
    
    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }
}