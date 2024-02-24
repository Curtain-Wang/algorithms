package look_back;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/7/18 14:17
 * @Description
 */
public class T83 {
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permut = permut(nums);
        System.out.println(permut);
    }
    
    private static List<List<Integer>> permut(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result);
        return result;
    }
    
    private static void helper(int[] nums, int i, List<List<Integer>> result) {
        if (i == nums.length){
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
        }else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                helper(nums, i + 1, result);
                swap(nums, i, j);
            }
        }
        
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
