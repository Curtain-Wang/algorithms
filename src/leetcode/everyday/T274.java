package leetcode.everyday;

/**
 * @Author Curtain
 * @Date 2023/10/30 11:28
 * @Description
 */
public class T274 {
    
    public static void main(String[] args) {
        int[] a = {1};
        System.out.println(new T274().hIndex(a));
    }
    
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length;
        while (left < right){
            int mid = left + (right - left) / 2 + 1;
            if (citations[citations.length - mid] >= mid){
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
}
