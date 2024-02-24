package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/25 15:37
 * @Description 最长回文子串
 * 
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */ 
public class T5_1 {
    int left = 0;
    int maxLength = 1;
    
    public static void main(String[] args) {
        System.out.println(new T5_1().longestPalindrome("cbbd"));
    }
    
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            calc(s, i, i, 1);
            if (i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i)){
                calc(s, i, i + 1, 2);
            }
        }
        return s.substring(left, left + maxLength);
    }
    
    private void calc(String s, int l, int r, int length) {
        while (l - 1 >= 0 && r + 1 < s.length() && s.charAt(l - 1) == s.charAt(r  - 1)){
            --l;
            ++r;
            length += 2;
        }
        if (length > maxLength){
            left = l;
            maxLength = length;
        }
    }
    
}
