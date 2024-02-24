package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/9/7 14:07
 * @Description
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class T78 {
    
    public static void main(String[] args) {
        int[] nums ={1, 2, 3};
        System.out.println(new T78().subsets(nums));
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> demo = new ArrayList<>();
        dg(nums, 0, demo, result);
        return result;
    }
    
    private void dg(int[] nums, int i, List<Integer> demo, List<List<Integer>> result) {
        if (i == nums.length){
            result.add(new ArrayList<>(demo));
        }else {
            dg(nums, i + 1, demo, result);
            demo.add(nums[i]);
            dg(nums, i + 1, demo, result);
            demo.remove(demo.size() - 1);
        }
    }
}
