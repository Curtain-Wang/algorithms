package leetcode.interview150;

import binary_search.ListNode;

import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/11/6 11:03
 * @Description 删除排序链表中的重复元素 II
 * 
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * 
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class T82 {
    
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(3);
        node3.next = node4;
        ListNode node5 = new ListNode(4);
        node4.next = node5;
        ListNode node6 = new ListNode(4);
        node5.next = node6;
        ListNode node7 = new ListNode(5);
        node6.next = node7;
        System.out.println(new T82().deleteDuplicates(node1));
    }
    
    
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentry = new ListNode();
        sentry.next = head;
        ListNode cur = head;
        ListNode pre = sentry;
        while (cur != null && cur.next != null){
            if (cur.val != cur.next.val){
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }else {
                cur = getCur(cur, cur.val);
            }
        }
        pre.next = cur;
        return sentry.next;
    }
    
    private ListNode getCur(ListNode cur, int val) {
        while (cur != null){
            if (cur.val != val){
                return cur;
            }
            cur = cur.next;
        }
        return cur;
    }
}
