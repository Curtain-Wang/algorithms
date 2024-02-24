package heap;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/6/27 16:20
 * @Description
 */
public class Practice {
    
    public List<Integer> topKFrequent(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k){
                queue.add(entry);
            }else if (queue.peek() != null && queue.peek().getValue() < entry.getValue()){
                queue.poll();
                queue.offer(entry);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : queue) {
            result.add(entry.getKey());
        }
        return result;
    }
    
    public List<List<Integer>> kSmallerPairs(int num1[], int num2[], int k){
        Queue<List<Integer>> queue = new PriorityQueue<>((e1, e2) -> e2.get(0) + e2.get(1) - e1.get(0) - e1.get(1));
        for (int i = 0; i < Math.min(k, num1.length); i++) {
            for (int j = 0; j < Math.min(k, num2.length); j++) {
                List<Integer> list = new ArrayList<>();
                list.add(num1[i]); 
                list.add(num2[j]);
                if (queue.size() < k){
                    queue.offer(list);
                }else if (queue.peek() != null && queue.peek().get(0) + queue.peek().get(1) - list.get(0) - list.get(1) > 0){
                    queue.poll();
                    queue.offer(list);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : queue) {
            result.add(list);
        }
        return result;
    }
    
    public List<List<Integer>> kSmallerestPairs(int[] nums1, int[] nums2, int k){
        Queue<int[]> queue = new PriorityQueue<>((e1, e2) -> nums1[e1[0]] + nums2[e1[1]] - nums1[e2[0]] - nums1[e2[1]]);
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums2 ==null || nums1.length == 0 || nums2.length == 0){
            return new ArrayList<>();
        }
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            queue.offer(new int[]{i, 0});
        }
        while (k-- > 0 && !queue.isEmpty()){
            int[] poll = queue.poll();
            result.add(Arrays.asList(nums1[poll[0]], nums1[poll[1]]));
            if (poll[1] < nums2.length - 1){
                queue.offer(new int[]{nums1[poll[0]], nums2[poll[1] + 1]});
            }
        }
        return result;
    }
}
