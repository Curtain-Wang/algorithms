package leetcode.hot100;

import java.util.Arrays;

/**
 * @Author Curtain
 * @Date 2023/8/16 10:43
 * @Description 下一个排列
 * 
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 * 
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class T31 {
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        new T31().nextPermutation(nums);
    }
    
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0){
            if (nums[i] < nums[i + 1]){
                break;
            }
            i--;
        }
        if (i >= 0){
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]){
                    swap(nums, i, j);
                    break;
                }
            }
        }
        reserve(nums, i + 1, nums.length);
    }
    
    private void reserve(int[] nums, int i, int length) {
        int left = i;
        int right = length - 1;
        while (left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    
    
    public void nextPermutation1(int[] nums) {
        int i = nums.length - 1;
        int max = -1;
        while (i >= 0){
            if (max > nums[i]){
                //说明该位要替换成大于它的最小数了
                break;
            }
            max = Math.max(nums[i], max);
            i--;
        }
        Arrays.sort(nums, i + 1, nums.length);
        if (i > -1){
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]){
                    swap(nums, i, j);
                    break;
                }
            } 
        }
    }
    
    private void swap(int[] nums, int i, int i1) {
        int temp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = temp;
    }
}
