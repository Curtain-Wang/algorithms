package leetcode.interview150;

import binary_search.ListNode;

import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/10/31 16:48
 * @Description
 */
public class T2 {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tmp = head;
        int carry = 0;
        while (l1 != null || l2 != null){
            int sum = carry;
            if (l1 != null){
                sum += l1.val;
            }
            if (l2 != null){
                sum += l2.val;
            }
            tmp.next = l1 == null ? l2 : l1;
            tmp.next.val = sum % 10;
            carry = sum / 10;
            tmp = tmp.next;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (carry > 0){
            ListNode listNode = new ListNode();
            listNode.val = carry;
            tmp.next = listNode;
        }
        return head.next;
    }
}
