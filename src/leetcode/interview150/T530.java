package leetcode.interview150;

import leetcode.hot100.TreeNode;

/**
 * @Author Curtain
 * @Date 2023/11/10 17:00
 * @Description
 */
public class T530 {
    
    public int getMinimumDifference(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        dfs(root, ans);
        return ans[0];
    }
    
    private void dfs(TreeNode node, int[] ans) {
        if (node == null){
            return;
        }
        if (node.left != null){
            ans[0] = Math.min(ans[0], node.val - node.left.val);
            dfs(node.left, ans);
        }
        if (node.right != null){
            ans[0] = Math.min(ans[0], node.right.val - node.val);
            dfs(node.right, ans); 
        }
    }
}
