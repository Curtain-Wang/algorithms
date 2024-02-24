package leetcode.interview150;

import leetcode.hot100.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/11/11 11:02
 * @Description
 */
public class T106 {
    
    Map<Integer, Integer> inMap = new HashMap<>();
    int[] inorder = null;
    int[] postorder = null;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return recur(postorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode recur(int rootPostIndex, int leftBorderInIndex, int rightBorderInIndex) { 
        if (leftBorderInIndex > rightBorderInIndex){
            return null;
        }
        TreeNode root = new TreeNode(postorder[rootPostIndex]);
        Integer rootInIndex = inMap.get(postorder[rootPostIndex]);
        root.right = recur(rootPostIndex - 1, rootInIndex + 1, rightBorderInIndex);
        root.left = recur(rootPostIndex - 1 - rightBorderInIndex + rootInIndex, leftBorderInIndex, rootInIndex - 1);
        return root;
    }
}
