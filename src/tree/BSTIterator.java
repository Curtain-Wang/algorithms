package tree;

import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/6/19 15:33
 * @Description
 */
public class BSTIterator {
    private TreeNode cur;
    private Stack<TreeNode> stack;
    
    
    public BSTIterator(TreeNode root){
        cur = root;
        stack = new Stack<>();
    }
    
    public boolean hasNext(){
        return cur != null || !stack.isEmpty(); 
    }
    
    public int next(){
        while (cur != null){
            stack.push(cur);
            cur = cur.getLeft();
        }
        cur = stack.pop();
        if (cur != null){
            int result = cur.getVal();
            cur = cur.getRight();
            return result;
        }else {
            return -1;
        }
    }
}
