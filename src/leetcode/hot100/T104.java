package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/1 15:36
 * @Description
 */
public class T104 {
    
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int[] maxDepth = {1};
        dfs(root, 1, maxDepth);
        return maxDepth[0];
    }
    
    private void dfs(TreeNode curNode, int depth, int[] maxDepth) {
        if (curNode == null){
            return;
        }
        if (depth > maxDepth[0]){
            maxDepth[0] = depth;
        }
        dfs(curNode.left, depth + 1, maxDepth);
        dfs(curNode.right, depth + 1, maxDepth);
    }
}
