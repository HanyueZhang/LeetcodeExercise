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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int zigzag = 0;
        while (!queue.isEmpty()) {
            ArrayList<Integer> sublist = new ArrayList<>();
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                TreeNode curr = queue.poll();
                if (zigzag % 2 == 0) {
                    sublist.add(curr.val);
                } else {
                    sublist.add(0, curr.val);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                // if (zigzag % 2 == 0) {
                //     //由于当前层zigzag决定的是下一层treenode的进队顺
                //     //所以当zigzag为偶数时，先右后左
                //     if (curr.right != null) {
                //         queue.offer(curr.right);
                //     }
                //     if (curr.left != null) { 
                //         queue.offer(curr.left);
                //     }
                // } else {
                //     if (curr.left != null) { 
                //         queue.offer(curr.left);
                //     }
                //     if (curr.right != null) {
                //         queue.offer(curr.right);
                //     }
                // }
            }
            list.add(sublist);
            zigzag++;
        }
        return list;
    }
}