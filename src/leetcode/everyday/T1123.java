package leetcode.everyday;

import javafx.util.Pair;

/**
 * @Author Curtain
 * @Date 2023/9/6 16:06
 * @Description
 */
public class T1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).getKey();
        
    }
    
    private Pair<TreeNode, Integer> dfs(TreeNode root) {
        if (root == null) {
            return new Pair<>(null, 0);
        }
        Pair<TreeNode, Integer> left = dfs(root.left);
        Pair<TreeNode, Integer> right = dfs(root.right);
        if (left.getValue() > right.getValue()) {
            return new Pair<>(left.getKey(), left.getValue() + 1);
        }
        if (left.getValue() < right.getValue()) {
            return new Pair<>(right.getKey(), right.getValue() + 1);
        }
        return new Pair<>(root, right.getValue() + 1);
    }
}
