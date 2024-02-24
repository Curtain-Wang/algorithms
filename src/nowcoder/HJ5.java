package nowcoder;

import java.util.Scanner;

/**
 * @Author Curtain
 * @Date 2024/2/23 9:47
 * @Description
 */
public class HJ5 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String next = in.next();
            int res = 0;
            int base = 1;
            for (int i = next.length() - 1; i > 1; i--) {
                char c = next.charAt(i);
                res += (c > '9' ? c - 'A' + 10 : c - '0') * base;
                base *= 16;
            }
            System.out.println(res);
        }
    }
}
