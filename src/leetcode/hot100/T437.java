package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/9/11 14:28
 * @Description
 * 
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 *
 */
public class T437 {
    
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCountMap = new HashMap<>();
        prefixSumCountMap.put(0L, 1);
        return dfs(root, targetSum, 0L, prefixSumCountMap);
    }
    
    private int dfs(TreeNode root, int targetSum, Long curSum, Map<Long, Integer> prefixSumCountMap) {
        if (root == null){
            return 0;
        }
        curSum += root.val;
        int res = prefixSumCountMap.getOrDefault(curSum - targetSum, 0);
        prefixSumCountMap.put(curSum, prefixSumCountMap.getOrDefault(curSum, 0) + 1);
        res += dfs(root.left, targetSum, curSum, prefixSumCountMap);
        res += dfs(root.right, targetSum, curSum, prefixSumCountMap);
        prefixSumCountMap.put(curSum, prefixSumCountMap.get(curSum) - 1);
        return res;
    }
}
