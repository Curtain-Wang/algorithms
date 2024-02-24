package nowcoder;

import java.util.Scanner;

/**
 * @Author Curtain
 * @Date 2024/2/23 16:56
 * @Description
 */
public class HJ46 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int length = Integer.valueOf(in.nextLine());
        System.out.println(s.substring(0, length));
    }
}
