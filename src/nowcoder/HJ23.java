package nowcoder;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2024/2/23 14:17
 * @Description
 * 
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 *
 * 数据范围：输入的字符串长度满足
 * 1≤n≤20  ，保证输入的字符串中仅出现小写字母
 * 输入描述：
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串。
 * 
 * 输入：
 * aabcddd
 * 输出：
 * aaddd
 */
public class HJ23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int[] arr = new int[26];
            String next = in.next();
            for (int i = 0; i < next.length(); i++) {
                arr[next.charAt(i) - 'a']++;
            }
            int min = Integer.MAX_VALUE;
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    continue;
                }
                if (arr[i] == min){
                    set.add((char) ('a' + i));
                }
                if (arr[i] < min){
                    min = arr[i];
                    set.clear();
                    set.add((char) ('a' + i));
                }
            }
            for (Character character : set) {
                next = next.replaceAll(String.valueOf(character), "");
            }
            System.out.println(next);
        }
    }
}
