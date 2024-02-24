package leetcode.hot100;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/9/5 14:33
 * @Description
 */
public class T46 {
    
    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(new T46().permute(nums));
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> demo = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        handle(nums, demo, result);
        return result;
    }
    
    private void handle(int[] nums, List<Integer> demo, List<List<Integer>> result) {
        if (demo.size() == nums.length){
            result.add(new ArrayList<>(demo));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 11){
                continue;
            }
            int tmp = nums[i];
            demo.add(tmp);
            nums[i] = 11;
            handle(nums, demo, result);
            nums[i] = tmp;
            demo.remove(demo.size() - 1);
        }
    }
}
