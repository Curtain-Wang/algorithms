package leetcode.interview150;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author Curtain
 * @Date 2024/1/4 9:31
 * @Description
 */
public class T295 {
}

class MedianFinder {
    
    Queue<Integer> a;
    Queue<Integer> b;
    
    public MedianFinder() {
        //小顶堆，存大的那一半的数据
        a = new PriorityQueue<>();
        //大顶堆，存小的那一半的数据
        b = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        if (a.size() == b.size()){
            a.offer(num);
        }else {
            b.offer(num);
        }
        if (b.size() > 0 && a.peek() < b.peek()){
            Integer polla = a.poll();
            Integer pollb = b.poll();
            a.offer(pollb);
            b.offer(polla);
        }
    }
    
    public double findMedian() {
        if (a.size() > b.size()){
            return a.peek();
        }else {
            double v = a.peek() + b.peek();
            return v / 2;
        }
    }
}
