package binary_search;

import java.util.Arrays;

/**
 * @Author Curtain
 * @Date 2023/6/30 16:16
 * @Description
 */
public class T7 {
    
    public static void main(String[] args) {
        int[] a = {4,8,1,2,7,6,9,3};
        sortArray1(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    
    private static int[] sortArray(int[] nums) {
        int length = nums.length;
        int[] dst = new int[length];
        int[] src = nums;
        for (int seg = 1; seg < length; seg += seg){
            for (int start = 0; start < length; start += 2 * seg){
                int mid = Math.min(start + seg, length);
                int end = Math.min(start + 2 * seg, length);
                int j = mid;
                int i = start;
                int k = start;
                while (i < mid || j < end){
                    if (j == end || (i < mid && src[i] < src[j])){
                        dst[k++] = src[i++];
                    }else {
                        dst[k++] = src[j++];
                    }
                }
            }
            int[] temp = src;
            src = dst;
            dst = temp;
        }
        return src;  
    }
    
    private static int[] sortArray1(int[] nums){
        int[] dst = Arrays.copyOf(nums, nums.length);
        sort(dst, nums, 0, nums.length);
        return nums;
    }
    
    private static void sort(int[] nums, int dst[], int start, int end) {
        if (end - start < 2){
            return; 
        }
        int mid = Math.min((start + end) / 2, nums.length);
        sort(dst, nums, start, mid);
        sort(dst, nums, mid, end);
        int i = start;
        int j = mid;
        int k = start;
        while (i < mid || j < end){
            if (j == end || (i < mid && nums[i] < nums[j])){
                dst[k++] = nums[i++];
            }else {
                dst[k++] = nums[j++];
            }
        }
        
    }
    
}
