package nowcoder;

import java.util.Scanner;

/**
 * @Author Curtain
 * @Date 2024/2/23 13:05
 * @Description
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 *
 * 输入：
 *
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 *
 * 坐标之间以;分隔。
 *
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 *
 * 下面是一个简单的例子 如：
 *
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 
 */
public class HJ17 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int x = 0;
        int y = 0;
        while (in.hasNext()) { // 注意 while 处理多个 case
            String next = in.next();
            String[] split = next.split(";");
            if (split != null && split.length > 0){
                for (String s : split) {
                    if (s.length() == 0){
                        continue;
                    }
                    char ch = s.charAt(0);
                    String substring = s.substring(1);
                    int value = 0;
                    boolean right = true;
                    for (int i = 0; i < substring.length(); i++) {
                        char c = substring.charAt(i);
                        if (c >= '0' && c <= '9'){
                            value *= 10;
                            value += c - '0';
                        }else {
                            right = false;
                            break;
                        }
                    }
                    if (right){
                        if (ch == 'A'){
                            x -= value;
                        }
                        if (ch == 'S'){
                            y -= value;
                        }
                        if (ch == 'D'){
                            x += value;
                        }
                        if (ch == 'W'){
                            y += value;
                        }
                    }
                }
            }
            System.out.println(x + "," + y);
        }
    }
}
