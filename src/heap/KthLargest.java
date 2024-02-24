package heap;

import java.util.PriorityQueue;

/**
 * @Author Curtain
 * @Date 2023/6/27 14:44
 * @Description
 */
public class KthLargest {
    private PriorityQueue<Integer> priorityQueue;
    private Integer size;
    
    public KthLargest(Integer[] nums, Integer k) {
        this.priorityQueue = new PriorityQueue();
        this.size = k;
        for (Integer num : nums) {
            add(num);
        }
    }
    
    
    private Integer add(Integer e){
        if (priorityQueue.size() < size){
            priorityQueue.add(e);
        }else {
            Integer peek = priorityQueue.peek();
            if (peek < e){
                priorityQueue.poll();
                priorityQueue.offer(e);
            }
        }
        return priorityQueue.peek();
    }
}
