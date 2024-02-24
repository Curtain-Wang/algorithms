package leetcode.interview150;

import leetcode.hot100.TreeNode;

/**
 * @Author Curtain
 * @Date 2023/11/9 20:40
 * @Description
 */
public class T222_1 {
    
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = level(root.left);
        int right = level(root.right);
        if (left == right){ //说明左子树满了
            return countNodes(root.right) + (1 << left);
        }else {
            return countNodes(root.left) + (1 << right);
        }
    }
    
    private int level(TreeNode root) {
        int level = 0;
        while (root != null){
            root = root.left;
            level++;
        }
        return level;
    }
}
