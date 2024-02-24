package leetcode.interview150;

import sun.reflect.generics.tree.Tree;

/**
 * @Author Curtain
 * @Date 2023/11/11 11:02
 * @Description
 */
public class T108 {
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }
    
    public static void main(String[] args) {
        System.out.println(new T108().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }
    
    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right){
            return null;
        }
        TreeNode root = new TreeNode();
        int mid = right + left >> 1;
        root.val = nums[mid];
        root.right = dfs(nums, mid + 1, right);
        root.left = dfs(nums, left, mid - 1);
        return root;
    }
    
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {
        }
        
        TreeNode(int val) {
            this.val = val;
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
}
