package binary_search;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/6/30 10:39
 * @Description
 */
public class T5 {
    
    public int[][] merge(int[][] intervals){
        List<int[]> merge = new ArrayList<>();
        int i = 0;
        while (i < intervals.length){
            int[] temp = new int[]{intervals[i][0], intervals[i][1]};
            int j = i + 1;
            while (intervals[j][0] <= temp[1]){
                temp[1] = Math.max(temp[1], intervals[j][1]);
                j++;
            }
            merge.add(temp);
            i = j;
        }
        int[][] result = new int[merge.size()][2];
        return merge.toArray(result);
    }
    
    public void sortArray(int[] nums){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(max,num);
        }
        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }
        int j = 0;
        for (int i = min; i <= max; i++) {
            while (count[i - min] > 0){
                nums[j++] = i;
                count[i - min]--;
            }
        }
    }
    
    public int[] relativeSortArray(int[] arr1, int[] arr2){
        int[] count = new int[1001];
        for (int num : arr1) {
            count[num]++;
        }
        int i = 0;
        for (int num : arr2) {
            while (count[num] > 0){
                arr1[i++] = num;
                count[num]--;
            }
        }
        for (int i1 = 0; i1 < count.length; i1++) {
            while (count[i1] > 0){
                arr1[i++] = i1;
                count[i1]--;
            }
        }
        return arr1;
    }
}
