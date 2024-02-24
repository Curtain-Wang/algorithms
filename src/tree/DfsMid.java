package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/6/15 10:17
 * @Description 深度优先搜索（Depth First Search） 之 中序遍历（Mid-order traversal）
 */
public class DfsMid {
    /**
     * 方法一；递归
     * 优点：简单
     * 缺陷：可能会导致方法栈溢出
     * @param root
     * @return
     */
    public List recursion(TreeNode root){
        List result = new ArrayList();
        search(root, result);
        return result;
    }
    
    private void search(TreeNode node, List result) {
        if (node == null){
            return;
        }
        search(node.getLeft(), result);
        result.add(node.getVal());
        search(node.getRight(), result);
        
    }
    
    /**
     * 方法二：栈
     * 优点：不用担心栈溢出
     * 缺点：比较难。。
     * @param root
     * @return
     */
    public List stack(TreeNode root){
        List result = new ArrayList();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.getLeft();
            }
            cur = stack.pop();
            result.add(cur.getVal());
            cur = cur.getRight();
        }
        return result;
    }
}
