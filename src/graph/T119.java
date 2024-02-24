package graph;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/8/10 14:21
 * @Description
 */
public class T119 {
    
    public static void main(String[] args) {
        Integer[] nums = {10, 5, 9, 2, 4, 3};
        System.out.println(new T119().longestConsecutive(nums));
    }
    
    private int longestConsecutive(Integer[] nums){
        int maxarea = 1;
        Set<Integer> numsSet = new HashSet<>(Arrays.asList(nums));
        for (int num : nums) {
            if (numsSet.contains(num)){
                maxarea = Math.max(maxarea, calcArea(numsSet, num));
            }
        }
        return maxarea;
    }
    
    private int calcArea(Set<Integer> nums, int num) {
        int area = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        while (!queue.isEmpty()){
            Integer remove = queue.remove();
            nums.remove(remove);
            Integer bigger = remove + 1;
            Integer smaller = remove - 1;
            if (nums.contains(bigger) && nums.contains(bigger)){
                queue.add(bigger);
                area++;
            }
            if (nums.contains(smaller) && nums.contains(smaller)){
                queue.add(smaller);
                area++;
            }
        }
        return area;
    }
}
