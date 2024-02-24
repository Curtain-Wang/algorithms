package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/10/9 17:17
 * @Description
 * 
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 *
 *
 */
public class T125 {
    
    public static void main(String[] args) {
        System.out.println(new T125().isPalindrome("A man, a plan, a canal: Panama"));
    }
    
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            //非字母字符
            char leftCh = s.charAt(left);
            char rightCh = s.charAt(right);
            if (!((leftCh >= 'a' && leftCh <= 'z') || (leftCh >= '0' && leftCh <= '9'))){
                left++;
                continue;
            }
            if (!((rightCh >= 'a' && rightCh <= 'z') || (rightCh >= '0' && rightCh <= '9'))){
                right--;
                continue;
            }
            if (leftCh != rightCh){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
}
