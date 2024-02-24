package leetcode.interview150;

import leetcode.hot100.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/11/15 10:22
 * @Description [1,2,5,3,4,null,6]
 */
public class T114 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node3;
        node1.right = node4;
        TreeNode node5 = new TreeNode(6);
        node2.right = node5;
        new T114().flatten(root);
    }
    
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1){
                list.get(i).right = list.get(i + 1);
            }
            list.get(i).left = null;
        }
    }
    
    private void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null){
            return;
        }
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
    }
    
}
