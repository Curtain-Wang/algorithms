package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/6 13:53
 * @Description
 */
public class T70 {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int step1 = 1;
        int step2 = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = step1 + step2;
            step1 = step2;
            step2 = tmp;
        }
        return step2;
    }
}
