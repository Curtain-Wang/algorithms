package leetcode.interview150;

import leetcode.hot100.TreeNode;

import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/11/23 14:32
 * @Description
 */
public class T98 {
    
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode lastNode = null;
        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (lastNode != null && lastNode.val >= cur.val){
                return false;
            }
            lastNode = cur;
            cur = cur.right;
        }
        return true;
    }
}
