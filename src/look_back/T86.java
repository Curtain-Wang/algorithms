package look_back;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/7/22 10:59
 * @Description
 */
public class T86 {
    
    public static void main(String[] args) {
        String s = "google";
        List<List<String>> partition = partition(s);
        System.out.println(partition);
    }
    
    public static List<List<String>> partition(String s){
        List<List<String>> result = new ArrayList<>();
        List<String> palindromeList = new ArrayList<>();
        helper(s, 0, palindromeList, result);
        return result;
    }
    
    
    private static void helper(String s, int start, List<String> palindromeList, List<List<String>> result) {
        if (start == s.length()){
            result.add(new ArrayList<>(palindromeList));
        }else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)){
                    palindromeList.add(s.substring(start, i + 1));
                    helper(s, i + 1, palindromeList, result);
                    palindromeList.remove(palindromeList.size() - 1);
                }
            }
        }
    }
    
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end){
            if (s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
