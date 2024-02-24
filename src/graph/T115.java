package graph;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/8/10 9:47
 * @Description
 */
public class T115 {
    
    
    public static void main(String[] args) {
        int[] org = {1, 2, 3};
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);list2.add(3);
        List<List<Integer>> seqs = new ArrayList<>();
        seqs.add(list1);
        seqs.add(list2);
        System.out.println(new T115().sequenceReconstruction(org, seqs));
    }
    
    private boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs){
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegreeMap = new HashMap<>();
        for (List<Integer> seq : seqs) {
            for (Integer num : seq) {
                if (num < 1 || num > org.length){
                    return false;
                }
                graph.putIfAbsent(num, new HashSet<>());
                inDegreeMap.putIfAbsent(num, 0);
            }
            for (int i = 1; i < seq.size(); i++) {
                Integer num1 = seq.get(i - 1);
                Integer num2 = seq.get(i);
                if (!graph.get(num1).contains(num2)){
                    graph.get(num1).add(num2);
                    inDegreeMap.put(num2, inDegreeMap.get(num2) + 1);
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Integer num : inDegreeMap.keySet()) {
            if (inDegreeMap.get(num) == 0){
                queue.add(num);
            }
        }
        List<Integer> seq = new ArrayList<>();
        while (queue.size() == 1){
            Integer num = queue.remove();
            seq.add(num);
            Set<Integer> integers = graph.get(num);
            for (Integer integer : integers) {
                inDegreeMap.put(integer, inDegreeMap.get(integer) - 1);
                if (inDegreeMap.get(integer) == 0){
                    queue.add(integer);
                }
            }
        }
        int[] ints = seq.stream().mapToInt(i -> i).toArray();
        return Arrays.equals(ints, org);
    }
}
