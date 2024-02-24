package leetcode.interview150;

import leetcode.hot100.TreeNode;

/**
 * @Author Curtain
 * @Date 2023/11/23 14:40
 * @Description
 */
public class T98_1 {
    
    long pre = Long.MIN_VALUE;
    
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        if (!isValidBST(root.left)){
            return false;
        }
        if (pre >= root.val){
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }
}
