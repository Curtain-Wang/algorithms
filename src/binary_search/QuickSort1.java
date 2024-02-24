package binary_search;

import java.util.Random;

/**
 * @Author Curtain
 * @Date 2023/7/4 11:04
 * @Description
 */
public class QuickSort1 {
    
    public static void main(String[] args) {
        int[] a = {4,8,1,2,7,6,9,3};
        sortArray(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
    
    public static void sortArray(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }
    
    private static void quickSort(int[] nums, int start, int end) {
        if (start < end){
            int index = partition(nums, start, end);
            quickSort(nums, start, index - 1);
            quickSort(nums, index + 1, end);
        }
        
    }
    
    private static int partition(int[] nums, int start, int end) {
        int index = new Random().nextInt(end - start + 1) + start;
        swap(nums, index, end);
        int i = start - 1;
        for (int j = start; j < end; j++){
            if (nums[j] < nums[end]){
                i++;
                swap(nums, i, j);
            }
        }
        i++;
        swap(nums, i, end);
        return i;
    }
    
    private static void swap(int[] nums, int index, int end) {
        int tmp = nums[end];
        nums[end] = nums[index];
        nums[index] = tmp;
    }
}
