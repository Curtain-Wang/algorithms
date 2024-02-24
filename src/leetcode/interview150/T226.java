package leetcode.interview150;

import leetcode.hot100.TreeNode;

/**
 * @Author Curtain
 * @Date 2023/11/7 19:13
 * @Description
 */
public class T226 {
    
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }
    
    //    private TreeNode dfs(TreeNode root) {
//        if (root == null){
//            return root;
//        }
//        TreeNode left = dfs(root.left);
//        TreeNode right = dfs(root.right);
//        root.left = right;
//        root.right = left;
//        return root;
//    }
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        dfs(root.left);
        dfs(root.right);
    }
    
}
