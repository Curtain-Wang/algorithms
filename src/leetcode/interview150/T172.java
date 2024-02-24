package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2024/1/11 10:24
 * @Description
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 *
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * 
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= n <= 10^4
 * 
 * 
 */
public class T172 {
    
    public static void main(String[] args) {
        System.out.println(new T172().trailingZeroes(13));
    }
    
    /**
     * 尾随0的个数，其实就是是因素2和5的个数，取小的那一个
     * 
     * 
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
