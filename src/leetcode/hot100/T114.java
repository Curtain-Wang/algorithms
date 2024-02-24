package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/8 15:14
 * @Description
 */
public class T114 {
    
    public void flatten(TreeNode root) {
        dfs(root);
    }
    
    private TreeNode dfs(TreeNode node) {
        if (node == null) {
            return node;
        }
        TreeNode tmp = node.right;
        node.right = dfs(node.left);
        node.left = null;
        TreeNode cur = node;
        while (cur.right != null){
            cur = cur.right;
        }
        cur.right = dfs(tmp);
        return node;
    }
}
