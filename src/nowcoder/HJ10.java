package nowcoder;

import java.util.Scanner;

/**
 * @Author Curtain
 * @Date 2024/2/23 10:26
 * @Description
 * 
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串 abaca 而言，有 a、b、c 三种不同的字符，因此输出 3 。
 *
 * 数据范围： 
 * 1
 * ≤
 * �
 * ≤
 * 500
 *
 * 1≤n≤500 
 * 输入描述：
 * 输入一行没有空格的字符串。
 *
 * 输出描述：
 * 输出 输入字符串 中范围在(0~127，包括0和127)字符的种数。
 *
 * 示例1
 * 输入：
 * abc
 * 复制
 * 输出：
 * 3
 * 复制
 * 示例2
 * 输入：
 * aaa
 * 复制
 * 输出：
 * 1
 */
public class HJ10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int[] arr = new int[128];
        int res = 0;
        while (in.hasNext()) { // 注意 while 处理多个 case
            String next = in.next();
            for (int i = 0; i < next.length(); i++) {
                arr[next.charAt(i)]++;
                if (arr[next.charAt(i)] == 1){
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
