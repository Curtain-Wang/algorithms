package binary_search;

import java.util.Random;

/**
 * @Author Curtain
 * @Date 2023/6/30 13:15
 * @Description
 */
public class T6 {
    
    private void sortArray(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }
    
    private void quickSort(int[] nums, int start, int end) {
        if (start < end){
            int pviot = partition(nums, start, end);
            quickSort(nums, start, pviot - 1);
            quickSort(nums, pviot + 1, end);
        }
    }
    
    private int partition(int[] nums, int start, int end) {
        int random = new Random().nextInt(end - start + 1) + start;
        swap(nums, random, end);
        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]){
                small++;
                swap(nums, small, i);
            }
        }
        small++;
        swap(nums, small, end);
        return small;
    }
    
    private void swap(int[] nums, int random, int end) {
        int temp = nums[end];
        nums[end] = nums[random];
        nums[random] = temp;
    }
    
    private int findKthLargest(int[] nums, int k){
        int target = nums.length - k;
        int index = partition(nums, 0, nums.length - 1);
        while (index != target){
            if (index > target){
                index = partition(nums, 0, index - 1);
            }else {
                partition(nums, index + 1, nums.length - 1);
            }
            
        }
        return index;
    }
}
