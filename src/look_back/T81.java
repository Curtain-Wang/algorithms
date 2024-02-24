package look_back;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/7/18 9:12
 * @Description
 */
public class T81 {
    
    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        List<List<Integer>> lists = conbineSum(nums, 8);
        System.out.println(lists);
    }
    
    private static List<List<Integer>> conbineSum(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subsets = new ArrayList<>();
        helper(nums, k, 0, subsets, result);
        return result;
    }
    
    private static void helper(int[] nums, int k, int i, List<Integer> subsets, List<List<Integer>> result) {
        if (0 == k) {
            result.add(new ArrayList<>(subsets));
        } else if (0 < k && i < nums.length) {
            helper(nums, k, i + 1, subsets, result);
            subsets.add(nums[i]);
            helper(nums, k - nums[i], i, subsets, result);
            subsets.remove(subsets.size() - 1);
        }
    }
}
