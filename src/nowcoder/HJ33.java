package nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Curtain
 * @Date 2024/2/23 14:31
 * @Description
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 *
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 *
 * 数据范围：保证输入的是合法的 IP 序列
 *
 * 输入描述：
 * 输入 
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 *
 * 输出描述：
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 */
public class HJ33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String next = in.next();
            if (next.contains(".")){
                Long res = 0L;
                String[] split = next.split("\\.");
                int base = 24;
                for (int i = 0; i < split.length; i++) {
                    int val = Integer.valueOf(split[i]);
                    List<Long> moveIndex = getMoveIndex(val);
                    for (Long index : moveIndex) {
                        res += (1L << index + base);
                    }
                    base -= 8;
                }
                System.out.println(res);
            }else {
                Long value = Long.valueOf(next);
                StringBuilder sb = new StringBuilder();
                for (int i = 24; i >= 0; i = i - 8) {
                    long ip = value >> i;
                    sb.append(ip);
                    value -= (ip << i);
                    if (i > 0){
                        sb.append(".");
                    }
                }
                System.out.println(sb);
            } 
        }
    }
    
    private static List<Long> getMoveIndex(int val) {
        List<Long> list = new ArrayList<>();
        Long moveIndex = 0L;
        while (val > 0){
            if ((val & 1) == 1){
                list.add(moveIndex);
            }
            moveIndex++;
            val >>= 1;
        }
        return list;
    }
}
