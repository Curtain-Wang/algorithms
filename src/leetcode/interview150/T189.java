package leetcode.interview150;

import java.util.Arrays;

/**
 * @Author Curtain
 * @Date 2023/10/8 15:05
 * @Description . 轮转数组
 * 
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 */
public class T189 {
    
    public void rotate(int[] nums, int k) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < copy.length; i++) {
            nums[(i + k) % nums.length] = copy[i];
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {-1, -100, 3, 99};
        new T189().rotate1(nums, 2);
        int a = 1;
    }
    
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        reserve(nums, 0, nums.length);
        reserve(nums, 0, k);
        reserve(nums, k, nums.length);
    }
    
    private void reserve(int[] nums, int start, int end) {
        int left = start;
        int right = end - 1;
        while (left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
