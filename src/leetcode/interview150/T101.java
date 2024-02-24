package leetcode.interview150;

import leetcode.hot100.TreeNode;

/**
 * @Author Curtain
 * @Date 2023/11/7 20:05
 * @Description
 */
public class T101 {
    
    public boolean isSymmetric(TreeNode root) {
        return bfs(root.left, root.right);
    }
    
    private boolean bfs(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return bfs(left.left, right.right) && bfs(left.right, right.left);
    }
    
}
