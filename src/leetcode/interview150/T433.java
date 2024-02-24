package leetcode.interview150;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/12/6 15:14
 * @Description 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 *
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 *
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
 *
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
 *
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 *
 *
 */
public class T433 {
    
    char[] chars = {'A', 'C', 'G', 'T'};
    
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String s : bank) {
            bankSet.add(s);
        }
        Queue<Node> queue = new ArrayDeque<>();
        Node node = new Node(startGene, 0);
        queue.add(node);
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            int cnt = node.cnt + 1;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    StringBuilder sb = new StringBuilder(poll.str);
                    sb.setCharAt(i, chars[j]);
                    String s = sb.toString();
                    if (!visited.contains(s) && bankSet.contains(s)){
                        if (s.equals(endGene)){
                            return cnt;
                        }
                        visited.add(s);
                        node = new Node(s, cnt);
                        queue.add(node);
                    }
                }
            }
        }
        return -1;
    }
    
    class Node {
        public String str;
        public int cnt;
    
    
        public Node(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
        
    }
    
}
