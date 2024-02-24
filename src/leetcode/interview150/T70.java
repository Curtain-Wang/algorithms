package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2024/1/12 10:11
 * @Description
 */
public class T70 {

    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        int a = 1;
        int b = 2;
        while (n > 2){
            int c = a + b;
            a = b;
            b = c;
            n--;
        }
        return b;
    }
}
