package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/8/10 18:55
 * @Description 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class T5 {
    private int left = 0;
    private int maxLength = 0;
    
    public static void main(String[] args) {
        System.out.println(new T5().longestPalindrome("ccc"));
    }
    
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            calc(s, i, i, 1);
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                calc(s, i, i + 1, 2);
            }
        }
        return s.substring(left, left + maxLength);
    }
    
    private void calc(String s, int i, int j, int length) {
        while (i - 1 >= 0 && j + 1< s.length() && s.charAt(i - 1) == s.charAt(j + 1)) {
            i--;
            j++;
            length = length + 2;
        }
        if (length > maxLength) {
            maxLength = length;
            left = i;
        }
    }
}

