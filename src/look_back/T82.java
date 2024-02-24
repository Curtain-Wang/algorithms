package look_back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/7/18 10:27
 * @Description
 */
public class T82 {
    
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 4, 3, 3};
        List<List<Integer>> lists = combinationSum(nums, 8);
        System.out.println(lists);
    }
    
    
    private static List<List<Integer>> combinationSum(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subsets = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, k, subsets, result);
        return result;
    }
    
    private static void helper(int[] nums, int i, int k, List<Integer> subsets, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(subsets));
        } else if (k > 0 && i < nums.length) {
            subsets.add(nums[i]);
            helper(nums, i + 1, k - nums[i], subsets, result);
            subsets.remove(subsets.size() - 1);
            helper(nums, getNext(nums, i), k, subsets, result);
            
        }
    }
    
    private static int getNext(int[] nums, int i) {
        int next = i;
        while (next < nums.length && nums[i] == nums[next]){
            next++;
        }
        return next;
    }
}
