package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2024/1/10 10:20
 * @Description
 */
public class T201 {
    
    public static void main(String[] args) {
        System.out.println(new T201().rangeBitwiseAnd(2147483646, 2147483647));
    }

    public int rangeBitwiseAnd(int left, int right) {
        int zeros = 0;
        while (left < right){
            zeros++;
            left >>>= 1;
            right >>>= 1;
        }
        return left << zeros;
    }
}
