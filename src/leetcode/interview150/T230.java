package leetcode.interview150;

import leetcode.hot100.TreeNode;

/**
 * @Author Curtain
 * @Date 2023/11/14 20:18
 * @Description
 */
public class T230 {
    
    int ans = -1;
    int count;
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return ans;
    }
    
    private void dfs(TreeNode root) {
        if (count == 0 || root == null){
            return;
        }
        dfs(root.left);
        count--;
        if (count == 0){
            ans = root.val;
            return;
        }
        dfs(root.right);
    }
}
