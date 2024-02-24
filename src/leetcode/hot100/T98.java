package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/7 20:41
 * @Description
 */
public class T98 {
    
    long pre = Long.MIN_VALUE;
    
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        if (!isValidBST(root.left)){
            return false;
        }
        if (root.val <= pre){
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }
    
    
}
