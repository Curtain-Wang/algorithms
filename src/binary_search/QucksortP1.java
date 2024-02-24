package binary_search;

import java.util.Random;

/**
 * @Author Curtain
 * @Date 2023/9/20 13:26
 * @Description
 */
public class QucksortP1 {
    
    public static void main(String[] args) {
        int[] a = {4,8,1,2,7,6,9,3};
        new QucksortP1().quicksort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }
    }
    
    public void quicksort(int nums[], int start, int end){
        if (start < end){
            int index = partition(nums, start, end);
            quicksort(nums, start, index - 1);
            quicksort(nums, index + 1, end);
        }
    }
    
    private int partition(int[] nums, int start, int end) {
        int index = new Random().nextInt(end - start + 1) + start;
        swap(nums, index, end);
        int left = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]){
                left++;
                swap(nums, left, i);
            }
        }
        left++;
        swap(nums, left, end);
        return left;
    }
    
    private void swap(int[] nums, int index, int end) {
        int temp = nums[index];
        nums[index] = nums[end];
        nums[end] = temp;
    }
}
