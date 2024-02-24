package tree;

import com.sun.org.apache.regexp.internal.RE;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/6/15 20:17
 * @Description 深度优先搜索（Depth First Search） 之 后序遍历（Post-order traversal）
 */
public class DfsPost {
    
    /**
     * 方法一；递归
     * 优点：简单
     * 缺陷：可能会导致方法栈溢出
     * @param root
     * @return
     */
    public List recursion(TreeNode root){
        List list = new ArrayList();
        search(root, list);
        return list;
    }
    
    private void search(TreeNode treeNode, List list) {
        if (treeNode == null){
            return;
        }
        search(treeNode.getLeft(), list);
        search(treeNode.getRight(), list);
        list.add(treeNode.getVal());
    }
    
    /**
     * 方法二：栈
     * 优点：不用担心栈溢出
     * 缺点：比较难。。
     * @return root     
     */
    
    private List stack(TreeNode root){
        List list = new ArrayList();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.getLeft();
            }
            cur = stack.peek();
            if (cur.getRight() != null && prev != cur.getRight()){
                cur = cur.getRight();
            }else {
                stack.pop();
                list.add(cur.getVal());
                prev = cur;
                cur = null;
            }
        }
        return list;
    }
}
