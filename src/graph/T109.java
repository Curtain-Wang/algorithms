package graph;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/8/9 10:05
 * @Description
 */
public class T109 {
    
    public static void main(String[] args) {
        String[] deads = {"0102", "0201"};
        System.out.println(new T109().openLock1(deads, "0202"));
    }
    
    public int openLock(String[] deads, String target){
        Set<String> deadSet = new HashSet<>(Arrays.asList(deads));
        if (deadSet.contains(target)){
            return -1;
        }
        Set<String> visited = new HashSet<>();
        String init = "0000";
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        queue1.add(init);
        visited.add(init);
        int length = 0;
        while (!queue1.isEmpty()){
            String now = queue1.remove();
            if (now.equals(target)){
                return length;
            }
            List<String> neighbors = getNeighbors(now);
            for (String neighbor : neighbors) {
                if (!deadSet.contains(neighbor) && !visited.contains(neighbor)){
                    queue2.add(neighbor);
                    visited.add(neighbor);
                }
            }
            if (queue1.isEmpty()){
                queue1 = queue2;
                queue2 = new LinkedList<>();
                length++;
            }
        }
        return length;
    }
    
    private List<String> getNeighbors(String now) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = now.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            chars[i] = aChar == '0' ? '9' : (char) (aChar - 1);
            neighbors.add(new String(chars));
            chars[i] = aChar == '9' ? '0' : (char) (aChar + 1);
            neighbors.add(new String(chars));
            chars[i] = aChar;
        }
        return neighbors;
    }
    
    public int openLock1(String[] deads, String target){
        Set<String> deadSet = new HashSet<>(Arrays.asList(deads));
        if (deadSet.contains(target)){
            return -1;
        }
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        String init = "0000";
        set1.add(init);
        set2.add(target);
        int length = 1;
        while (!set1.isEmpty() && !set2.isEmpty()){
            if (set1.size() > set2.size()){
                Set<String> tmp = set2;
                set2 = set1;
                set1 = tmp;
            }
            Set<String> set3 = new HashSet();
            for (String s : set1) {
                List<String> neighbors = getNeighbors(s);
                for (String neighbor : neighbors) {
                    if (set2.contains(neighbor)){
                        return length;
                    }
                    if (!visited.contains(neighbor) && !deadSet.contains(neighbor)){
                        set3.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            length++;
            set1 = set3;
        }
        return length;
    }
}
