package leetcode.everyday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/8/15 9:46
 * @Description 字符串中的查找与替换
 * 
 * 你会得到一个字符串 s (索引从 0 开始)，你必须对它执行 k 个替换操作。替换操作以三个长度均为 k 的并行数组给出：indices, sources,  targets。
 *
 * 要完成第 i 个替换操作:
 *
 * 检查 子字符串  sources[i] 是否出现在 原字符串 s 的索引 indices[i] 处。
 * 如果没有出现， 什么也不做 。
 * 如果出现，则用 targets[i] 替换 该子字符串。
 * 例如，如果 s = "abcd" ， indices[i] = 0 , sources[i] = "ab"， targets[i] = "eee" ，那么替换的结果将是 "eeecd" 。
 *
 * 所有替换操作必须 同时 发生，这意味着替换操作不应该影响彼此的索引。测试用例保证元素间不会重叠 。
 *
 * 例如，一个 s = "abc" ，  indices = [0,1] ， sources = ["ab"，"bc"] 的测试用例将不会生成，因为 "ab" 和 "bc" 替换重叠。
 * 在对 s 执行所有替换操作后返回 结果字符串 。
 *
 * 子字符串 是字符串中连续的字符序列。
 * 
 * 提示：
 *
 * 1 <= s.length <= 1000
 * k == indices.length == sources.length == targets.length
 * 1 <= k <= 100
 * 0 <= indexes[i] < s.length
 * 1 <= sources[i].length, targets[i].length <= 50
 * s 仅由小写英文字母组成
 * sources[i] 和 targets[i] 仅由小写英文字母组成
 */
public class T833 {
    
    public static void main(String[] args) {
        int[] indices = {0, 2};
        String[] sources = {"ab","ec"};
        String[] targets = {"eee","ffff"};
        System.out.println(new T833().findReplaceString("abcd", indices, sources, targets));
    }
    
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, String> sourceMap = new HashMap<>();
        Map<Integer, String> targetMap = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            sourceMap.put(indices[i], sources[i]);
            targetMap.put(indices[i], targets[i]);
        }
        Arrays.sort(indices);
        int indexI = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            //遍历到一个替换开始点
            if (indexI < indices.length && i == indices[indexI]){
                String sourceStr = sourceMap.get(i);
                if (isSubStr(s, sourceStr, i)){
                    sb.append(targetMap.get(i));
                    i += sourceStr.length() - 1;
                }else {
                    sb.append(s.charAt(i));
                }
                indexI++;
            }else {
                sb.append(s.charAt(i));
            }
        }
        return indexI == indices.length ? sb.toString() : s;
    }
    
    private boolean isSubStr(String s, String s1, int i) {
        return s.substring(i, i + s1.length()).equals(s1);
    }
    
}
