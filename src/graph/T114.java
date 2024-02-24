package graph;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/8/9 17:19
 * @Description
 */
public class T114 {
    
    public static void main(String[] args) {
        String[] words = {"ac", "ab", "bc", "zc", "zb"};
        System.out.println(new T114().alienOrder(words));
    }
    
    private String alienOrder(String[] words){
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> charDegree = new HashMap<>();
        for (int i = 1; i < words.length; i++) {
            String lastWord = words[i - 1];
            String word = words[i];
            if (lastWord.startsWith(word) && !lastWord.equals(word)){
                return "";
            }
            for (int j = 0; j < lastWord.length(); j++) {
                char ch1 = lastWord.charAt(j);
                char ch2 = word.charAt(j);
                graph.putIfAbsent(ch1, new HashSet<>());
                graph.putIfAbsent(ch2, new HashSet<>());
                charDegree.putIfAbsent(ch2, 0);
                charDegree.putIfAbsent(ch1, 0);
                if (ch1 != ch2){
                    if (!graph.get(ch1).contains(ch2)){
                        graph.get(ch1).add(ch2);
                        charDegree.put(ch2, charDegree.get(ch2) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList();
        for (Map.Entry<Character, Integer> characterIntegerEntry : charDegree.entrySet()) {
            if (characterIntegerEntry.getValue() == 0){
                queue.add(characterIntegerEntry.getKey());
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            Character remove = queue.remove();
            sb.append(remove);
            Set<Character> characters = graph.get(remove);
            for (Character character : characters) {
                charDegree.put(character, charDegree.get(character) - 1);
                if (charDegree.get(character) == 0){
                    queue.add(character);
                }
            }
        }
        return sb.toString();
    }
}
