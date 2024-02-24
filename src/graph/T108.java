package graph;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/8/7 16:42
 * @Description
 */
public class T108 {
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(new T108().ladderLength1("hit", "cog", list));
    }
    
    private int ladderLength(String beginWord, String endWord, List<String> wordList){
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        Set<String> notVisited = new HashSet<>(wordList);
        queue1.add(beginWord);
        int length = 1;
        while (!queue1.isEmpty()){
            String nowWord = queue1.remove();
            if (nowWord.equals(endWord)){
                return length;
            }
            List<String> neighborWords = getNeighborWords(nowWord);
            for (String neighborWord : neighborWords) {
                if (notVisited.contains(neighborWord)){
                    queue2.add(neighborWord);
                    notVisited.remove(neighborWord);
                }
            }
            if (queue1.isEmpty()){
                length++;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return 0;
    }
    
    private List<String> getNeighborWords(String nowWord) {
        char[] chars = nowWord.toCharArray();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char oldChar = chars[i];
            for (char newChar = 'a'; newChar <= 'z'; newChar++){
                if (oldChar != newChar){
                    chars[i] = newChar;
                    result.add(new String(chars));
                }
            }
            chars[i] = oldChar;
        }
        return result;
    }
    
    private int ladderLength1(String beginWord, String endWord, List<String> wordList){
        Set<String> notVisited = new HashSet<>(wordList);
        if (!notVisited.contains(endWord)){
            return 0;
        }
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add(beginWord);
        set2.add(endWord);
        notVisited.remove(endWord);
        int length = 2;
        while (!set1.isEmpty() && !set2.isEmpty()){
            if (set1.size() > set2.size()){
                Set<String> temp = set2;
                set2 = set1;
                set1 = temp;
            }
            Set<String> set3 = new HashSet<>();
            for (String s : set1) {
                List<String> neighborWords = getNeighborWords(s);
                for (String neighborWord : neighborWords) {
                    if (set2.contains(neighborWord)){
                        return length;
                    }
                    if (notVisited.contains(neighborWord)){
                        notVisited.remove(neighborWord);
                        set3.add(neighborWord);
                    }
                }
            }
            set1 = set3;
            length++;
        }
        return 0;
    }
}
