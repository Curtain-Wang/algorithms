package binary_search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/7/17 16:38
 * @Description
 */
public class T10 {
    
    public static void main(String[] args) {
        int[] nums = {2, 4, 6};
        List<List<Integer>> result = subset(nums);
        System.out.println(result);
    }
    
    
    private static List<List<Integer>> subset(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0){
            return result;
        }
        List<Integer> subsets = new ArrayList<>();
        helper(nums, 0, subsets, result);
        return result;
    }
    
    private static void helper(int[] nums, int i, List<Integer> subsets, List<List<Integer>> result) {
        if (i == nums.length){
            result.add(new ArrayList<>(subsets));
        }else {
            helper(nums, i + 1, subsets, result);
            subsets.add(nums[i]);
            helper(nums, i + 1, subsets, result);
            subsets.remove(subsets.size() - 1);
        }
    }
}
