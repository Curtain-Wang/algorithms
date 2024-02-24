package graph;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/8/10 15:00
 * @Description
 */
public class T119_1 {
    
    
    public static void main(String[] args) {
        Integer[] nums = {10, 5, 9, 2, 4, 3};
        System.out.println(new T119_1().longestConsecutive(nums));
    }
    
    private int longestConsecutive(Integer[] nums){
        Map<Integer, Integer> fathers = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        Set<Integer> all = new HashSet<>();
        for (Integer num : nums) {
            fathers.put(num, num);
            counts.put(num, 1);
            all.add(num);
        }
        for (Integer num : nums) {
            if (all.contains(num - 1)){
                union(fathers, counts, num, num - 1);
            }
            if (all.contains(num + 1)){
                union(fathers, counts, num, num + 1);
            }
        }
        int length = 0;
        for (Integer value : counts.values()) {
            length = Math.max(length, value);
        }
        return length;
    }
    
    private void union(Map<Integer, Integer> fathers, Map<Integer, Integer> counts, Integer i, int j) {
        int fatherI = findFather(fathers, i);
        int fatherJ = findFather(fathers, j);
        if (fatherI != fatherJ){
            fathers.put(fatherI, fatherJ);
            int counti = counts.get(fatherI);
            int countj = counts.get(fatherJ);
            counts.put(fatherJ, counti + countj);
        }
    }
    
    private int findFather(Map<Integer, Integer> fathers, Integer i) {
        if (!fathers.get(i).equals(i)){
            fathers.put(i, findFather(fathers, fathers.get(i)));
        }
        return fathers.get(i);
    }
    
}
