package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/9/4 9:51
 * @Description
 */
public class T101 {

//    public boolean isSymmetric(TreeNode root) {
//        return bfs(root.left, root.right);
//    }
//    
//    private boolean bfs(TreeNode left, TreeNode right) {
//        if (left == null && right == null){
//            return true;
//        }
//        if (left == null || right == null){
//            return false;
//        }
//        if (left.val != right.val){
//            return false;
//        }
//        return bfs(left.left, right.right) && bfs(left.right, right.left);
//    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(3);
        node1.left = null;
        node1.right = node3;
        TreeNode node4 = new TreeNode(3);
        node2.left = null;
        node2.right = node4;
        System.out.println(new T101().isSymmetric(root));
    }
    
    
    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            List sonList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                //判断对不对称
                TreeNode treeNode1 = list.get(i);
                TreeNode treeNode2 = list.get(list.size() - 1 - i);
                if (treeNode1 == null && treeNode2 == null) {
                    continue;
                }
                if (treeNode1 == null || treeNode2 == null) {
                    return false;
                }
                if (treeNode1.val != treeNode2.val) {
                    return false;
                }
                sonList.add(treeNode1.left);
                sonList.add(treeNode1.right);
                
            }
            list = sonList;
        }
        return true;
    }
}
