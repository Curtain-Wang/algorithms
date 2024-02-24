package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/6 17:36
 * @Description
 */
public class T108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }
    
    private TreeNode dfs(int[] nums, int start, int end) {
        if (start > end){
            return null;
        }
        int mid = start + end >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, start, mid - 1);
        root.right = dfs(nums, mid + 1, end);
        return root;
    }
}
