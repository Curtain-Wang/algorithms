package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Curtain
 * @Date 2023/8/10 13:34
 * @Description
 */
public class T117_1 {
    
    public static void main(String[] args) {
        String[] words = {"tars", "rats", "arts", "star"};
        System.out.println(new T117_1().numSimilarGroups(words));
        
    }
    
    private int numSimilarGroups(String[] words) {
        int count = 0;
        boolean[] visited = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {
                count++;
                findSimilar(visited, words, i);
            }
        }
        return count;
    }
    
    private void findSimilar(boolean[] visited, String[] words, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while (!queue.isEmpty()){
            Integer remove = queue.remove();
            visited[remove] = true;
            for (int j = 0; j < words.length; j++) {
                if (!visited[j] && similar(words, remove, j)){
                    queue.add(j);
                }
            }
        }
    }
    
    private boolean similar(String[] words, Integer remove, int j) {
        char[] chars = words[remove].toCharArray();
        char[] chars1 = words[j].toCharArray();
        int diff = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars1[i]){
                diff++;
            }
        }
        return diff == 2;
    }
}
