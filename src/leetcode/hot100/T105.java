package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/9/11 14:11
 * @Description
 */
public class T105 {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
        }
    
    private TreeNode buildHelper(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend, Map<Integer, Integer> map) {
        if (pstart >= pend || istart >= iend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pstart]);
        int rootIndex = map.get(root.val);
        int leftNum = rootIndex - istart;
        root.left = buildHelper(preorder, pstart + 1, pstart + leftNum + 1, inorder, istart, rootIndex, map);
        root.right = buildHelper(preorder, pstart + leftNum + 1, pend, inorder, rootIndex + 1, iend, map);
        return root;
    }
}
