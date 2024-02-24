package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2024/1/31 9:23
 * @Description
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 *
 * 提示：
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 */
public class T72 {
    /**
     *              f(a - 1, b - 1)  a = b
     * f(a, b) = 
     *              Math.min(f(a, b - 1), f(a - 1, b)) + 1  a != b
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];
        for (int i = 0; i <= word2.length(); i++) {
            dp[i] = i;
        }
        for (int i = 0; i < word1.length(); i++) {
            int leftRight = dp[0];
            dp[0] = i + 1;
            for (int j = 0; j < word2.length(); j++) {
                int old = dp[j + 1];
                if (word1.charAt(i) == word2.charAt(j)){
                    dp[j + 1] = leftRight;
                }else {
                    dp[j + 1] = Math.min(Math.min(dp[j], old), leftRight) + 1;
                }
                leftRight = old;
            }
        }
        return dp[word2.length()];
    }
}