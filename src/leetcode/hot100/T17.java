package leetcode.hot100;

import javax.swing.text.MaskFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/8/11 9:47
 * @Description 电话号码的字母组合
 * 
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class T17 {
    char[][] phone = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},{'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    
    public static void main(String[] args) {
        String digits =
                "7";
        System.out.println(new T17().letterCombinations(digits));
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        //特殊情况
        if (digits == null || digits.length() == 0){
            return result;
        }
        StringBuilder sb = new StringBuilder();
        makeLetter(result, digits, sb, 0);
        return result;
    }
    
    private void makeLetter(List<String> result, String digits, StringBuilder sb, int i) {
        if (i == digits.length()){
            result.add(new String(sb));
        }else {
            int index = digits.charAt(i) - '2';
            for (char c : phone[index]) {
                sb.append(c);
                makeLetter(result, digits, sb, i + 1);
                sb.deleteCharAt(i);
            }
        }
    }
}
