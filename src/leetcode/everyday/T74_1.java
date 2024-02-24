package leetcode.everyday;

import java.util.Arrays;

/**
 * @Author Curtain
 * @Date 2023/10/29 12:24
 * @Description
 */
public class T74_1 {
    
    public static void main(String[] args) {
        int[] a = {0};
        System.out.println(new T74_1().hIndex(a));
    }
    
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length;
        while (left < right){
            int mid = left + (right - left) / 2 + 1;
            int count = count(citations, mid);
            if (count >= mid){
                left = mid;
            }else if (count < mid){
                right = mid - 1;
            }
        }
        return left;
    }
    
    private int count(int[] citations, int mid) {
        int count = 0;
        for (int citation : citations) {
            if (citation >= mid){
                count++;
            }
        }
        return count;
    }
}
