package leetcode.hot100;

import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/8/15 9:34
 * @Description 20. 有效的括号
 * 
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * 
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class T20 {
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() % 2 != 0){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c || '{' == c || '[' == c){
                stack.push(c);
            }else {
                if (stack.size() == 0){
                    return false;
                }
                Character pop = stack.pop();
                if (('(' == pop && ')' == c) || ('{' == pop && '}' == c) || ('[' == pop && ']' == c)){
                    continue;
                }else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
