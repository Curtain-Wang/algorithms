package leetcode.interview150;

import leetcode.hot100.TreeNode;

/**
 * @Author Curtain
 * @Date 2023/11/14 20:15
 * @Description
 */
public class T150_1 {
    int ans = Integer.MAX_VALUE;
    int pre = -1;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        dfs(root.left);
        if (pre != -1){
            ans = Math.min(root.val - pre, ans);
        }
        pre = root.val;
        dfs(root.right);
    }
}
