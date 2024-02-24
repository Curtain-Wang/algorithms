package leetcode.interview150;

import java.util.Arrays;

/**
 * @Author Curtain
 * @Date 2023/10/8 16:25
 * @Description
 * 
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 *
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且每篇论文 至少 被引用 h 次。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 */
public class T274 {
    
    public static void main(String[] args) {
        int[] a = {0};
        System.out.println(new T274().hIndex(a));
    }
    
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length;
        while (left < right){
            int mid = left + (right - left >> 1) + 1;
            if (cal(citations, mid) >= mid){
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
    
    private int cal(int[] citations, int mid) {
        int ans = 0;
        for (int citation : citations) {
            if (citation >= mid){
                ans++;
            }
        }
        return ans;
    }
    
    public int hIndex1(int[] citations) {
        Arrays.sort(citations);
        int h = citations.length;
        while (h >= 0){
            if (citations[citations.length - h] >= h){
                return h;
            }
            h--;
        }
        return h;
    }
}
