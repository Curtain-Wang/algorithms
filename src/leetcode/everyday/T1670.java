package leetcode.everyday;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author Curtain
 * @Date 2023/11/28 19:08
 * @Description
 */
public class T1670 {
    
    public static void main(String[] args) {
        FrontMiddleBackQueue frontMiddleBackQueue = new FrontMiddleBackQueue();
        frontMiddleBackQueue.pushFront(1);
        frontMiddleBackQueue.pushBack(2);
        frontMiddleBackQueue.pushMiddle(3);
        frontMiddleBackQueue.pushMiddle(4);
        System.out.println(frontMiddleBackQueue.popFront());
        System.out.println(frontMiddleBackQueue.popMiddle());
        System.out.println(frontMiddleBackQueue.popMiddle());
        System.out.println(frontMiddleBackQueue.popBack());
        System.out.println(frontMiddleBackQueue.popFront());

    }
    
    static class FrontMiddleBackQueue {
        private Deque<Integer> front = new ArrayDeque<>();
        private Deque<Integer> behind = new ArrayDeque<>();
        
        public FrontMiddleBackQueue() {
            
        }
        
        public void pushFront(int val) {
            front.push(val);
            balance();
        }
        
        public void pushMiddle(int val) {
            if (front.size() - behind.size() == 1){
                behind.push(front.pollLast());
            }
            front.addLast(val);
            balance();
        }
        
        public void pushBack(int val) {
            behind.addLast(val);
            balance();
        }
        
        public int popFront() {
            if (front.size() == 0){
                return -1;
            }
            int val = front.poll();
            balance();
            return val;
        }
        
        public int popMiddle() {
            if (front.size() == 0){
                return -1;
            }
            int val = front.pollLast();
            balance();
            return val;
        }
        
        public int popBack() {
            int val = 0;
            if (behind.size() > 0){
                val = behind.pollLast();
            }else if (front.size() > 0){
                val = front.pollLast();
            }else {
                return -1;
            }
            balance();
            return val;
        }
        
        private void balance(){
            if (front.size() - behind.size() == 2){
                behind.push(front.pollLast());
            }
            if (behind.size() - front.size() == 1){
                front.addLast(behind.poll());
            }
        }
    }
}
