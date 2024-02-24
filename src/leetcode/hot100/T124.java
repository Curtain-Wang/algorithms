package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/12 10:57
 * @Description
 */
public class T124 {
    
    int max = -1000;
    
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    
    private int dfs(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            int leftMaxValue = Math.max(0, dfs(root.left));
            int rightMaxValue = Math.max(0, dfs(root.right));
            max = Math.max(max, leftMaxValue + rightMaxValue + root.val);
            return root.val + (leftMaxValue > rightMaxValue ? leftMaxValue : rightMaxValue);
        }
    }
}
