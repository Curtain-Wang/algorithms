package leetcode.interview150;

import binary_search.ListNode;

/**
 * @Author Curtain
 * @Date 2023/11/6 13:44
 * @Description  分隔链表
 * 
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class T86 {
    
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        System.out.println(new T86().partition(node1, 2));
    }
    
    public ListNode partition(ListNode head, int x) {
        ListNode sentrySmall = new ListNode();
        ListNode sentryBig  = new ListNode();
        ListNode smallCur = sentrySmall;
        ListNode bigCur = sentryBig;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            if (cur.val < x){
                smallCur.next = cur;
                smallCur = cur;
            }else {
                bigCur.next = cur;
                bigCur = cur;
                
            }
            cur = next;
        }
        smallCur.next = sentryBig.next;
        bigCur.next = null;
        return sentrySmall.next;
    }
}
