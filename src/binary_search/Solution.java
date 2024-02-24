package binary_search;

import java.util.Random;

/**
 * @Author Curtain
 * @Date 2023/6/29 19:36
 * @Description
 */
public class Solution {
    
    private int[] sums;
    private int total;
    
    public Solution(int[] w) {
        sums = new int[w.length];
        total = 0;
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            sums[i] = total;
        }
    }
    
    public int pickIndex(){
        Random random = new Random();
        int x = random.nextInt(total);
        int left = 0;
        int right = sums.length - 1;
        while (left <= right){
            int mid = left + right / 2;
            if (sums[mid] > x){
                if (mid == 0 || sums[mid - 1] <= x){
                    return mid;
                }
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
