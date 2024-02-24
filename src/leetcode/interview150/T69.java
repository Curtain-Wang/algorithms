package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2024/1/3 11:00
 * @Description
 */
public class T69 {
    
    public static void main(String[] args) {
        System.out.println(new T69().mySqrt(2147395599));
    }
    
    public int mySqrt(int x) {
        int start = 0;
        int end = x;
        while (start < end){
            int mid = start + (end - start) / 2 + 1;
            if (x / mid >= mid){
                start = mid;
            }else {
                end = mid - 1;
            }
        }
        return start;
    }
}
