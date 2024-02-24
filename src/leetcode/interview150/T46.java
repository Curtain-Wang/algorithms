package leetcode.interview150;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Curtain
 * @Date 2023/12/18 15:38
 * @Description
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class T46 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> demo = new ArrayList<>();
    int k;
    Set<Integer> visited = new HashSet<>();
    int[] nums;
    
    public List<List<Integer>> permute(int[] nums) {
        k = nums.length;
        this.nums = nums;
        dfs();
        return result;
    }
    
    private void dfs() {
        if (demo.size() == k){
            result.add(new ArrayList<>(demo));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (!visited.contains(nums[i])){
                    visited.add(nums[i]);
                    demo.add(nums[i]);
                    dfs();
                    visited.remove(nums[i]);
                    demo.remove(demo.size() - 1);
                }
            }
        }
    }
}
