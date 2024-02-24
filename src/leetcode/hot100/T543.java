package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/6 16:58
 * @Description
 */
public class T543 {
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        root.left = node;
        System.out.println(new T543().diameterOfBinaryTree(root));
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = {0};
        dfs(root, result);
        return result[0];
    }
    
    private int dfs(TreeNode root, int[] result) {
        if (root == null){
            return 0;
        }
        int left = dfs(root.left, result);
        int right = dfs(root.right, result);
        result[0] = Math.max(result[0], left + right);
        return Math.max(left, right) + 1;
    }
}
