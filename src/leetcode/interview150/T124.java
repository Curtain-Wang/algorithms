package leetcode.interview150;

import leetcode.hot100.TreeNode;

/**
 * @Author Curtain
 * @Date 2023/11/21 14:57
 * @Description
 */
public class T124 {
    int max = Integer.MIN_VALUE;
    
    
    public static void main(String[] args) {
        TreeNode left = new TreeNode(-1);
        TreeNode root = new TreeNode(2, left, null);
        System.out.println(new T124().maxPathSum(root));
    }
    
    
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    
    private int dfs(TreeNode cur) {
        if (cur == null){
            return 0;
        }
        int leftMaxValue = dfs(cur.left);
        int rightMaxValue = dfs(cur.right);
        int result = Math.max(leftMaxValue + cur.val, rightMaxValue + cur.val);
        max = Math.max(Math.max(result, leftMaxValue + cur.val + rightMaxValue), max);
        
        return result < 0 ? 0 : result;
    }
}
