package leetcode.hot100;

import javax.swing.*;
import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/8/10 20:22
 * @Description 15. 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * 
 * 提示：
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class T15 {
    
    public static void main(String[] args) {
        int[]nums = {-1,0,1,2,-1,-4};
        System.out.println(new T15().threeSum(nums));
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //特例
        if (nums == null || nums.length < 3){
            return result;
        }
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    //左右指针都往里面移动
                    //右指针左移
                    while (right > left + 1 && nums[right] == nums[right - 1]){
                        right--;
                    }
                    right--;
                    //左指针右移
                    while (left < right - 1 && nums[left] == nums[left + 1]){
                        left++;
                    }
                    left++;
                }else if (sum > 0){
                    //右指针左移
                    while (right > left + 1 && nums[right] == nums[right - 1]){
                        right--;
                    }
                    right--;
                }else {
                    //左指针右移
                    while (left < right - 1 && nums[left] == nums[left + 1]){
                        left++;
                    }
                    left++;
                }
            }
        }
        return result;
    }
}
