package leetcode.interview150;

import leetcode.hot100.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/11/11 10:41
 * @Description
 */
public class T105 {
    
    Map<Integer, Integer> inMap = new HashMap<>();
    int[] preorder = null;
    int[] inorder = null;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        //中序遍历，val -> index
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }
    
    /**
     * 
     * @param rootPreIndex 前序遍历中的根节点的索引
     * @param inSonLeftBorderIndex 中序遍历中的 子树的左边界
     * @param inSonRightBorderIndex 中序遍历中的 子树的右边界
     * @return
     */
    private TreeNode recur(int rootPreIndex, int inSonLeftBorderIndex, int inSonRightBorderIndex) {
        if (inSonLeftBorderIndex > inSonRightBorderIndex){
            return null;
        }
        TreeNode root = new TreeNode(preorder[rootPreIndex]);
        int rootInIndex = inMap.get(preorder[rootPreIndex]);
        root.left = recur(rootPreIndex + 1, inSonLeftBorderIndex, rootInIndex - 1);
        root.right = recur(rootPreIndex + rootInIndex - inSonLeftBorderIndex + 1, rootInIndex + 1, inSonRightBorderIndex);
        return root;
    }
}
