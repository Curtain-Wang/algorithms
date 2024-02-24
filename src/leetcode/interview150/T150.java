package leetcode.interview150;

import leetcode.hot100.TreeNode;

import java.util.Arrays;

/**
 * @Author Curtain
 * @Date 2023/11/14 19:57
 * @Description
 */
public class T150 {
    
    public int getMinimumDifference(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        dfs(root, ans);
        return ans[0];
    }
    
    private int[] dfs(TreeNode root, int[] ans) {
        if (root == null){
            return null;
        }
        int[] result = new int[2];
        Arrays.fill(result, root.val);
        if (root.left != null){
            int[] leftResult = dfs(root.left, ans);
            result[0] = leftResult[0];
            ans[0] = Math.min(ans[0], root.val - leftResult[1]);
        }
        if (root.right != null){
           int[] rightResult = dfs(root.right, ans);
           ans[0] = Math.min(ans[0], rightResult[0] - root.val);
           result[1] = rightResult[1];
        }
        return result;
    }
}
