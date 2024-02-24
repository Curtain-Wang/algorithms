package leetcode.interview150;

import leetcode.hot100.TreeNode;

/**
 * @Author Curtain
 * @Date 2023/11/15 10:41
 * @Description
 */
public class T114_1 {
    private TreeNode pre = null;
    
    public void flatten(TreeNode root) {
        dfs(root);
    }
    
    private void dfs(TreeNode cur) {
        if (cur == null){
            return;
        }
        TreeNode left = cur.left;
        TreeNode right = cur.right;
        if (pre != null){
            pre.right = cur;
        }
        pre = cur;
        pre.left = null;
        dfs(left);
        dfs(right);
    }
}
