package leetcode.interview150;

import binary_search.ListNode;

import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/12/21 15:39
 * @Description 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class T148 {
//    public ListNode sortList(ListNode head) {
//        List<Integer> vals = new ArrayList<>();
//        ListNode cur = head;
//        while (cur != null){
//            vals.add(cur.val);
//            cur = cur.next;
//        }
//        vals.sort((o1, o2) -> o1 - o2);
//        int i = 0;
//        cur = head;
//        while (cur != null){
//            cur.val = vals.get(i++);
//            cur = cur.next;
//        }
//        return head;
//    }
    
//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null)
//            return head;
//        ListNode fast = head.next, slow = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        ListNode tmp = slow.next;
//        slow.next = null;
//        ListNode left = sortList(head);
//        ListNode right = sortList(tmp);
//        ListNode h = new ListNode(0);
//        ListNode res = h;
//        while (left != null && right != null) {
//            if (left.val < right.val) {
//                h.next = left;
//                left = left.next;
//            } else {
//                h.next = right;
//                right = right.next;
//            }
//            h = h.next;
//        }
//        h.next = left != null ? left : right;
//        return res.next;
//    }
    
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        System.out.println(new T148().sortList(node));
    }
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode be = sortList(slow.next);
        slow.next = null;
        ListNode front = sortList(head);
        ListNode h = new ListNode();
        ListNode res = h;
        while (front != null && be != null){
            if (front.val > be.val){
                h.next = be;
                be = be.next;
            }else {
                h.next = front;
                front = front.next;
            }
            h = h.next;
        }
        h.next = front == null ? be : front;
        return res.next;
    }
}
