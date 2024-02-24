package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/10/11 14:42
 * @Description
 */
public class T151_1 {
    
    public String reverseWords(String s) {
        s = s.trim();
        int i = s.length() - 1;
        int j = i;
        StringBuilder sb = new StringBuilder();
        while (i >= 0){
            while (i >=0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s.substring(i + 1, j + 1)).append(" ");
            while (i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            j = i;
        }
        s = sb.toString();
        return s.trim();
    }
}
