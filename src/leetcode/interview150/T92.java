package leetcode.interview150;

import binary_search.ListNode;

import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/11/1 14:52
 * @Description 反转链表 II
 * 
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class T92 {
    
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(new T92().reverseBetween(node, 2, 4));
    }
    
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftPre = null;
        ListNode leftNode = null;
        ListNode rightAfter = null;
        ListNode sentry = new ListNode();
        sentry.next = head;
        ListNode pre = sentry;
        while (right > 0){
            if (left == 1){
                leftNode = pre.next;
                leftPre = pre;
            }
            if (right == 1){
                rightAfter = pre.next.next;
                pre.next.next = null;
            }
            pre = pre.next;
            left--;
            right--;
        }
        leftPre.next = reserve(leftNode);
        leftNode.next = rightAfter;
        return sentry.next;
    }
    
    private ListNode reserve(ListNode leftNode) {
        ListNode cur = leftNode;
        ListNode pre = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;     
        }
        return pre;
    }
}
