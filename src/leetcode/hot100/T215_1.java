package leetcode.hot100;

import java.util.Random;

/**
 * @Author Curtain
 * @Date 2023/9/20 11:34
 * @Description
 */
public class T215_1 {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[k];
        }
        int index = partition(nums, left, right);
        if (index == k){
            return nums[index];
        }else if (index > k){
            return quickSelect(nums, left, index - 1, k);
        }else {
            return quickSelect(nums, index + 1, right, k);
        }
    }
    
    private int partition(int[] nums, int left, int right) {
        int rad = new Random().nextInt(right - left + 1) + left;
        int i = left - 1;
        swap(nums, rad, right);
        for (int j = left; j < right; j++) {
            if (nums[j] < nums[right]){
                swap(nums, ++i, j);
            }
        }
        swap(nums, ++i, right);
        return i;
    }
    
    private void swap(int[] nums, int rad, int right) {
        int temp = nums[rad];
        nums[rad] = nums[right];
        nums[right] = temp;
    }
}
