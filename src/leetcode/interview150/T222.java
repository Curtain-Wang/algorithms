package leetcode.interview150;

import leetcode.hot100.TreeNode;

/**
 * @Author Curtain
 * @Date 2023/11/9 20:29
 * @Description
 */
public class T222 {
    public int countNodes(TreeNode root) {
        int[] ans = new int[1];
        dfs(ans, root);
        return ans[0];
    }
    
    private void dfs(int[] ans, TreeNode root) {
        if (root == null){
            return;
        }
        ans[0]++;
        dfs(ans, root.left);
        dfs(ans, root.right);
    }
}
