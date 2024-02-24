package leetcode.hot100;

import java.util.Arrays;

/**
 * @Author Curtain
 * @Date 2023/8/21 15:11
 * @Description
 */
public class T189 {
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        new T189().rotate(nums, 3);
    }
    
//    public void rotate(int[] nums, int k) {
//        k %= nums.length;
//        int[] ints = Arrays.copyOf(nums, nums.length);
//        for (int i = 0; i < ints.length; i++) {
//            nums[(i + k) % nums.length] = ints[i];
//        }
//    }
    
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reserve(nums, 0, nums.length - 1);
        reserve(nums, 0, k - 1);
        reserve(nums, k, nums.length - 1);
    }
    
    private void reserve(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
