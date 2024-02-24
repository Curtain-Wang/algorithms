package leetcode.hot100;

import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/9/8 14:45
 * @Description
 */
public class T230 {
    /**
     * [5,3,6,2,4,null,null,1]
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        System.out.println(new T230().kthSmallest(root, 3));
    }
    
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curNode = root;
        while (!stack.isEmpty()){
            while (curNode != null && curNode.left != null){
                stack.push(curNode.left);
                curNode = curNode.left;
            }
            TreeNode pop = stack.pop();
            if (k == 1){
                return pop.val;
            }
            k--;
            if (pop.right != null){
                stack.push(pop.right);
                curNode = pop.right;
            }else {
                curNode = null;
            }
        }
        return -1;
    }
}
