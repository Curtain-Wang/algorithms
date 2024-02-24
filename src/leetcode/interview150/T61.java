package leetcode.interview150;

import binary_search.ListNode;

/**
 * @Author Curtain
 * @Date 2023/11/6 13:10
 * @Description 旋转链表
 * 
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class T61 {
    
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null){
            return head;
        }
        ListNode cur = head;
        int length = 0;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        k %= length;
        //找到倒数第k的节点，改节点是尾节点
        ListNode front = head;
        ListNode behind = head;
        for (int i = 0; i < k; i++) {
            front = front.next;
        }
        while (front.next != null){
            front = front.next;
            behind = behind.next;
        }
        front.next = head;
        head = behind.next;
        behind.next = null;
        return head;
    }
}
