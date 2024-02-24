package leetcode.interview150;

import leetcode.hot100.TreeNode;

/**
 * @Author Curtain
 * @Date 2023/10/30 16:06
 * @Description
 */
public class T104 {
    
    public int maxDepth(TreeNode root) {
        return dg(root);
    }
    
    private int dg(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = dg(root.left);
        int right = dg(root.right);
        return Math.max(left, right) + 1;
    }
}
