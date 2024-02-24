package tree;

import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/6/19 16:38
 * @Description
 */
public class BSTIteratorReserved {
    private TreeNode cur;
    private Stack<TreeNode> stack;
    
    public BSTIteratorReserved(TreeNode root){
        this.cur = root;
        stack = new Stack<>();
    }
    
    public boolean hasPrev(){
        return cur != null || !stack.isEmpty();
    }
    
    public int prev(){
        while (cur != null){
            stack.push(cur);
            cur = cur.getRight();
        }
        cur = stack.pop();
        int result  = cur.getVal();
        cur = cur.getLeft();
        return result;
    }
    
}
