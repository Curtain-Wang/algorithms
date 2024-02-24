package leetcode.interview150;


import leetcode.hot100.TreeNode;

/**
 * @Author Curtain
 * @Date 2023/11/17 16:37
 * @Description
 */
public class T129 {
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    
    private void dfs(TreeNode cur, int i) {
        if (cur == null){
            return;
        }
        int curValue = i * 10 + cur.val;
        if (cur.left == null && cur.right == null){
            ans += curValue;
            return;
        }
        dfs(cur.left, curValue);
        dfs(cur.right, curValue);
    }
}
