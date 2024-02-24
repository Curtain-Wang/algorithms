package leetcode.interview150;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author Curtain
 * @Date 2023/12/7 16:38
 * @Description
 */
public class T443_1 {
    
    class Solution {
        private char[] geneChars = new char[]{'A', 'C', 'G', 'T'};
        
        public int minMutation(String startGene, String endGene, String[] bank) {
            Set<String> lib = new HashSet<>();     // 存储基因库的基因，用于快速判断转移的基因是否有效
            for(String b: bank){
                lib.add(b); // 基因库的基因字符串加入哈希表
            }
            Set<String> visited = new HashSet<>();   // 存储遍历过的基因
            visited.add(startGene);
            Queue<Node> queue = new LinkedList<>();   // 存储待搜索的基因字符串以及从起点基因变成这个基因的最少变化次数
            queue.offer(new Node(startGene, 0));   // 初始起点字符串入队，且变化数为0
            
            while(!queue.isEmpty()){
                Node node = queue.poll();     // 获取队首节点
                String gene = node.gene;
                int cnt = node.cnt;    // 获取当前处理的基因字符串和最少变化数
                cnt++;      // 最少变化数加1，用于下一个变化的基因字符串
                for(int i =0; i < 8; i++){
                    // 依次改变当前基因的某一位
                    for(int j = 0; j < 4; j++){
                        // 枚举四个字符改变当前位i作为下一个处理的基因字符串，即使有一个是当前字符串，但是当前的已经加入visited，因此也不会重复处理 
                        StringBuilder nextBuilder = new StringBuilder(gene);     // 不能直接对当前字符串修改，避免一个位修改了改不回来了，就变成不止改一个位
                        nextBuilder.setCharAt(i, geneChars[j]);    // 替换当前位的字符位枚举的j个字符
                        String next= nextBuilder.toString();
                        if(!visited.contains(next) && lib.contains(next)){
                            // next基因没有处理过且在库里，是一个可转移的节点
                            if(next.equals(endGene))return cnt;  // 转移到了终点基因字符串，返回最少变化数
                            visited.add(next);      // 下一个基因字符串入哈希表，表示已经入队了
                            queue.offer(new Node(next, cnt));  // 入队
                        }
                    }
                }
            }
            
            return -1;  // 退出循环说明不能转移到终点基因比吗。返回-1
        }
    }
    
    // 用于BFS过程中队列存储的数据
    class Node{
        String gene;
        int cnt;
        
        public Node(String gene, int cnt){
            this.gene = gene;
            this.cnt = cnt;
        }
    }
}
