package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/6/15 19:28
 * @Description 深度优先搜索（Depth First Search）之 前序遍历（Preorder traversal）
 * 
 */
public class DfsPre {
    
    /**
     * 方法一；递归
     * 优点：简单
     * 缺陷：可能会导致方法栈溢出
     * @param root
     * @return
     */
    public List recursion(TreeNode root){
        List list = new ArrayList();
        search(list, root);
        return list;
    }
    
    private void search(List list, TreeNode treeNode) {
        if (treeNode == null){
            return;
        }
        list.add(treeNode.getVal());
        search(list, treeNode.getLeft());
        search(list, treeNode.getRight());
    }
    
    /**
     * 方法二：栈
     * 优点：不用担心栈溢出
     * 缺点：比较难。。
     * @param root
     * @return
     */
    public List stack(TreeNode root){
        List list = new ArrayList();
        if (root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                list.add(cur.getVal());
                stack.push(cur);
                cur = cur.getLeft();
            }
            cur = stack.pop();
            cur = cur.getRight();
            
        }
        
        
        
        return list;
    }
}
