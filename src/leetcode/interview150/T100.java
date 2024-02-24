package leetcode.interview150;

import leetcode.hot100.TreeNode;

/**
 * @Author Curtain
 * @Date 2023/10/25 15:25
 * @Description
 */
public class T100 {
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
