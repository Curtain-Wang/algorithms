package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/12/29 16:17
 * @Description
 */
public class T67 {
    
    public static void main(String[] args) {
        System.out.println(new T67().addBinary("11", "1"));
    }
    
    public String addBinary(String a, String b) {
        int n = Math.max(a.length(), b.length());
        int i = 1;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while (i <= n){
            int ai = 0, bi = 0;
            if (i <= a.length()){
                ai = a.charAt(a.length() - i) - '0';
            }
            if (i <= b.length()){
                bi = b.charAt(b.length() - i) - '0';
            }
            int val = ai + bi + add;
            if (val >= 2){
                add = 1;
                val %= 2;
            }else {
                add = 0;
            }
            StringBuilder stringBuilder = new StringBuilder(val + "");
            stringBuilder.append(sb);
            sb = stringBuilder;
            i++;
        }
        if (add == 1){
            StringBuilder stringBuilder = new StringBuilder("1");
            stringBuilder.append(sb);
            sb = stringBuilder;
        }
        return sb.toString();
    }
}
