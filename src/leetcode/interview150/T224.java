package leetcode.interview150;

import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/10/23 9:38
 * @Description 基本计算器
 * <p>
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 10^5
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
 * '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
 * 输入中不存在两个连续的操作符
 * 每个数字和运行的计算将适合于一个有符号的 32位 整数
 */
public class T224 {
    
    public static void main(String[] args) {
        String s = "1-(     -2)";
        System.out.println(s.trim().replaceAll(" ", ""));
        System.out.println(s.replaceAll("\\(\\+", "(0+"));
        System.out.println(new T224().calculate(s));
    }
    
    public int calculate(String s) {
        s = s.trim().replaceAll(" ", "").replaceAll("\\(\\+", "(0+").replaceAll("\\(\\-", "(0-");
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            s = 0 + s;
        }
        Stack<Character> operatorStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                operatorStack.push(c);
            } else if (c == '+' || c == '-') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    int secondNum = numStack.pop();
                    int firstNum = numStack.pop();
                    numStack.push(calc(firstNum, secondNum, operatorStack.pop()));
                }
                operatorStack.push(c);
            } else if (c == ')') {
                while (operatorStack.peek() != '(') {
                    int secondNum = numStack.pop();
                    int firstNum = numStack.pop();
                    numStack.push(calc(firstNum, secondNum, operatorStack.pop()));
                }
                //将左括号弹出
                operatorStack.pop();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                while (i + 1 < s.length() && (s.charAt(i + 1) >= '0' || s.charAt(i + 1) <= 9)) {
                    sb.append(s.charAt(++i));
                }
                numStack.push(Integer.valueOf(sb.toString()));
            }
        }
        while (!operatorStack.isEmpty()) {
            int secondNum = numStack.pop();
            int firstNum = numStack.pop();
            numStack.push(calc(firstNum, secondNum, operatorStack.pop()));
        }
        return numStack.pop();
    }
    
    private Integer calc(int firstNum, int secondNum, Character pop) {
        return pop.equals('+') ? firstNum + secondNum : firstNum - secondNum;
    }
    
}
