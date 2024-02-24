package nowcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author Curtain
 * @Date 2024/2/23 13:28
 * @Description
 * 密码要求:
 *
 * 1.长度超过8位
 *
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 *
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 *
 * 数据范围：输入的字符串长度满足 1≤n≤100 
 * 输入描述：
 * 一组字符串。
 *
 * 输出描述：
 * 如果符合要求输出：OK，否则输出NG
 * 
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * ok
 * ng
 * ng
 * ok
 */
public class HJ20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String next = in.next();
            if (!checkLength(next) || !check2(next) || !check3(next)){
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }
    
    private static boolean check3(String next) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < next.length(); i++) {
            if (i < next.length() - 2){
                String s = next.substring(i, i + 3);
                if (set.contains(s)){
                    return false;
                }
                set.add(s);
            }
        }
        return true;
    }
    
    private static boolean check2(String next) {
        //大写、小写、数字、其他符号
        int[] arr = new int[4];
        
        for (int i = 0; i < next.length(); i++) {
            char c = next.charAt(i);
            if (c >= 'A' && c <= 'Z'){
                arr[0]++;
            }else if (c >= 'a' && c <= 'z'){
                arr[1]++;
            }else if (c >= '0' && c <= '9'){
                arr[2]++;
            }else if (c != ' '){
                arr[3]++;
            }
        }
        int count = 0;
        for (int i : arr) {
            if (i > 0){
                count++;
            }
        }
        return count >= 3;
    }
    
    private static boolean checkLength(String next) {
        return next.length() > 8;
    }
}
