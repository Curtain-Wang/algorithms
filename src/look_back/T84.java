package look_back;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Curtain
 * @Date 2023/7/18 16:31
 * @Description
 */
public class T84 {
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> permut = permut(nums);
        System.out.println(permut);
    }
    
    private static List<List<Integer>> permut(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result);
        return result;
    }
    
    private static void helper(int[] nums, int i, List<List<Integer>> result) {
        if (i == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
        } else {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                if (!set.contains(nums[j])){
                    set.add(nums[j]);
                    swap(nums, i, j);
                    helper(nums, i + 1, result);
                    swap(nums, i, j);
                }
            }
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
