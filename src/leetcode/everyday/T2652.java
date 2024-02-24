package leetcode.everyday;

/**
 * @Author Curtain
 * @Date 2023/10/17 13:25
 * @Description
 * 
 * 给你一个正整数 n ，请你计算在 [1，n] 范围内能被 3、5、7 整除的所有整数之和。
 *
 * 返回一个整数，用于表示给定范围内所有满足约束条件的数字之和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 7
 * 输出：21
 * 解释：在 [1, 7] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7 。数字之和为 21 。
 * 示例 2：
 *
 * 输入：n = 10
 * 输出：40
 * 解释：在 [1, 10] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7、9、10 。数字之和为 40 。
 * 示例 3：
 *
 * 输入：n = 9
 * 输出：30
 * 解释：在 [1, 9] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7、9 。数字之和为 30 。
 *
 *
 * 提示：
 *
 * 1 <= n <= 10^3
 */
public class T2652 {
    
    int n = 0;
//    public int sumOfMultiples1(int n) {
//        int ans = 0;
//        for (int i = 1; i <= n; i++) {
//            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0){
//                ans += i;
//            }
//        }
//        return ans;
//    }
    
    public static void main(String[] args) {
        System.out.println(new T2652().sumOfMultiples(7));
    }
    
    public int sumOfMultiples(int n) {
        this.n = n;
        return f(3) + f(5) + f(7) - f(3 * 5) - f(3 * 7) - f(3 * 5 * 7);
    }
    
    private int f(int i) {
        return (i + n / i * i) * (n / i) / 2;
    }
}
