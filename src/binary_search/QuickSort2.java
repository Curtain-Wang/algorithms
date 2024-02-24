package binary_search;

import java.util.Random;

/**
 * @Author Curtain
 * @Date 2023/7/13 9:54
 * @Description
 */
public class QuickSort2 {
    
    public static void main(String[] args) {
        int[] a = {4,8,1,2,7,6,9,3};
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
    
    public static void sort(int[] a){
        quicksort(a, 0, a.length - 1);
    }
    
    private static void quicksort(int[] a, int start, int end) {
        if (start >= end){
            return;
        }
        int index = random(a, start, end);
        quicksort(a, start, index - 1);
        quicksort(a, index + 1, end);
        
    }
    
    private static int random(int[] a, int start, int end) {
        int index = new Random().nextInt(end - start + 1) + start;
        swap(a, index, end);
        int i = start - 1;
        for (int j = start; j < end; j++){
            if (a[j] < a[end]){
                swap(a, ++i, j);
            }
        }
        swap(a, ++i, end);
        return i;
    }
    
    private static void swap(int[] a, int index, int end) {
        int temp = a[index];
        a[index] = a[end];
        a[end] = temp;
    }
}
