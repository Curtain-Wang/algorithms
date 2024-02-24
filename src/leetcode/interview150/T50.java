package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2024/2/20 14:06
 * @Description
 * 
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，x^n ）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * 提示：
 *
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * n 是一个整数
 * 要么 x 不为零，要么 n > 0 。
 * -10^4 <= x^n <= 10^4
 */
public class T50 {
    
    public double myPow(double x, int n) {
        if (x == 0.0f || x == 1.0f){
            return x;
        }
        if (n == 0){
            return 1.0d;
        }
        long b = n;
        if (b < 0){
            x = 1 / x;
            b = -b;
        }
        double res = 1.0;
        while (b > 0){
            if ((b & 1) == 1){
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
