package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/10/11 14:59
 * @Description
 */
public class T151_2 {
    
    public static void main(String[] args) {
        System.out.println(new T151_2().reverseWords("a good   example"));
    }
    
    public String reverseWords(String s) {
        String[] ss = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            if (!ss[i].equals("")){
                sb.append(ss[i]);
                if (i != 0){
                    sb.append(" ");
                }
            }
            
        }
        return sb.toString();
    }
}
