package leetcode.interview150;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/12/7 16:57
 * @Description
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 *
 * 每一对相邻的单词只差一个字母。
 *  对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 */
public class T127 {
    
    public static void main(String[] args) {
        System.out.println(new T127().ladderLength("hit", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }
        Set<String> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node();
        node.str = beginWord;
        node.cnt = 1;
        queue.offer(node);
        visited.add(node.str);
        while (!queue.isEmpty()){
            node = queue.poll();
            int cnt = node.cnt + 1;
            for (int i = 0; i < node.str.length(); i++) {
                StringBuilder stringBuilder = new StringBuilder(node.str);
                for (int j = 0; j < 26; j++) {
                    char changeChar = (char) ('a' + j);
                    stringBuilder.setCharAt(i, changeChar);
                    String s = stringBuilder.toString();
                    if (!visited.contains(s) && set.contains(s)){
                        if (s.equals(endWord)){
                            return cnt;
                        }
                        visited.add(s);
                        Node node1 = new Node();
                        node1.str = s;
                        node1.cnt = cnt;
                        queue.add(node1);
                    }
                }
            }
        }
        return 0;
    }
    
    class Node {
        String str;
        int cnt;
    }
}
