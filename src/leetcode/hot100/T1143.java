package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/26 13:20
 * @Description 最长公共子序列
 * 
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * 
 * 示例 1：
 *
 * 输入：text1 = "abcde", text2 = "ace" 
 * 输出：3  
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 示例 3：
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 *
 *
 * 提示：
 *
 * 1 <= text1.length, text2.length <= 1000
 * text1 和 text2 仅由小写英文字符组成。
 */
public class T1143 {
    
    public int longestCommonSubsequence(String text1, String text2) {
        if (text2.length() > text1.length()){
            String tmp = text2;
            text2 = text1;
            text1 = tmp;
        }
        int[] dp = new int[text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            int leftTop = 0;
            for (int j = 0; j < text2.length(); j++) {
                int temp = dp[j + 1];
                if (text1.charAt(i) == text2.charAt(j)){
                    dp[j + 1] = leftTop + 1;
                }else {
                    dp[j + 1] = Math.max(dp[j], dp[j + 1]);
                }
                leftTop = temp;
            }
        }
        return dp[text2.length()];
    }
}
