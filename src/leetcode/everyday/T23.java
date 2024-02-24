package leetcode.everyday;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author Curtain
 * @Date 2023/8/12 11:41
 * @Description
 */
public class T23 {
    
    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        node2.next = node1;
        ListNode node3 = new ListNode(1);
        node3.next = node2;
        
        ListNode node11 = new ListNode(4);
        ListNode node22 = new ListNode(3);
        node22.next = node11;
        ListNode node33 = new ListNode(1);
        node33.next = node22;
        
        ListNode node111 = new ListNode(6);
        ListNode node222 = new ListNode(2);
        node222.next = node111;
        
        ListNode[] lists = {node3, node33, node222};
        new T23().mergeKLists(lists);
    }
    
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = null;
        Queue<ListNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for (ListNode node : lists) {
            if (node != null){
                queue.add(node);
            }
        }
        if (!queue.isEmpty()) {
            result = queue.poll();
            if (result.next != null) {
                queue.add(result.next);
            }
        }
        ListNode tmp = result;
        while (!queue.isEmpty()) {
            ListNode peek = queue.poll();
            tmp.next = peek;
            if (peek.next != null) {
                queue.add(peek.next);
            }
            tmp = peek;
        }
        return result;
    }
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
