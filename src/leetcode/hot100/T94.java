package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/9/1 15:00
 * @Description
 */
public class T94 {
    
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        head.right = node2;
        TreeNode node3 = new TreeNode(3);
        node2.left = node3;
        List<Integer> list = new T94().inorderTraversal(head);
        System.out.println(list);
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curNode = root;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (curNode != null || !stack.isEmpty()){
            while (curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            }
            TreeNode pop = stack.pop();
            list.add(pop.val);
            curNode = pop.right;
        }
        return list;
    }
    
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }
    
    private void dfs(TreeNode node, List<Integer> result) {
        if (node == null){
            return;
        }
        dfs(node.left, result);
        result.add(node.val);
        dfs(node.right, result);
    }
}


