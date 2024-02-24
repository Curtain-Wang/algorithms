package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2024/1/22 10:38
 * @Description
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
public class T5 {
    
    int left = 0;
    int maxLength = 1;
    
    public static void main(String[] args) {
        System.out.println(new T5().longestPalindrome("cbbd"));
    }
    
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            calc(s, i, i);
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)){
                calc(s, i, i + 1);
            }
        }
        return s.substring(left, left + maxLength);
    }
    
    private void calc(String s, int i, int j) {
        while (i - 1 >= 0 && j + 1 < s.length() && s.charAt(i - 1) == s.charAt(j + 1)){
            i--;
            j++;
        }
        if (j - i + 1 > maxLength){
            left = i;
            maxLength = j - i + 1;
        }
    }
    
}
