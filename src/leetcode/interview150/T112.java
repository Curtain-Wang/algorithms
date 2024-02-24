package leetcode.interview150;

import leetcode.hot100.TreeNode;

/**
 * @Author Curtain
 * @Date 2023/11/9 20:15
 * @Description
 */
public class T112 {
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }
    
    private boolean dfs(TreeNode root, int sum, int targetSum) {
        if (root == null){
            return false;
        }
        //叶子节点
        if (root.left == null && root.right == null){
            return sum + root.val == targetSum;
        }
        return dfs(root.left, root.val + sum, targetSum) || dfs(root.right, root.val + sum, targetSum);
    }
}
