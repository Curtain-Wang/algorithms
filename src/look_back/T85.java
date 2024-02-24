package look_back;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/7/22 10:32
 * @Description
 */
public class T85 {
    
    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        System.out.println(list);
    }
    
    public static List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        helper(n, n, "",result);
        return result;
    }
    
    private static void helper(int left, int right, String s, List<String> result) {
        if (left == 0 && right == 0){
            result.add(s);
        }else {
            if (left > 0){
                helper(left - 1, right, s + "(", result);
            }
            if (right > left){
                helper(left, right - 1, s + ")", result);
            }
        }
    }
}
