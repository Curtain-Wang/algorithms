package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/4 9:44
 * @Description
 */
public class T226 {
    
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }
    
    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        dfs(root.left);
        dfs(root.right);
    }
}
