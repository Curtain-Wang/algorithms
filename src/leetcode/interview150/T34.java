package leetcode.interview150;

import java.util.Arrays;

/**
 * @Author Curtain
 * @Date 2023/12/26 15:21
 * @Description
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums 是一个非递减数组
 * -10^9 <= target <= 10^9
 */
public class T34 {
    
    public static void main(String[] args) {
        System.out.println(new T34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        if (nums.length == 0){
            return ans;
        }
        int left = 0;
        int right = nums.length - 1;
        //查询右边界
        while (left < right){
            int mid = left + right + 1>> 1;
            if (nums[mid] <= target){
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        if (nums[left] == target){
            ans[1] = left;
        }else {
            return ans;
        }
        //查询左边界
        left = 0;
        right = nums.length - 1;
        while (left < right){
            int mid = left + right>> 1;
            if (nums[mid] >= target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        ans[0] = right;
        return ans;
    }
}
