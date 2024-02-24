package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/10/12 9:18
 * @Description 最后一个单词的长度
 * 
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 *1 <= s.length <= 10^4
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 */
public class T58 {
    public int lengthOfLastWord(String s) {
        int right = s.length() - 1;
        while (right >= 0 && s.charAt(right) == ' '){
            right--;
        }
        int left = right;
        while (left >= 0 && s.charAt(left) != ' '){
            left--;
        }
        return right - left;
    }
}
