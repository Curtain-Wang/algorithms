package leetcode.interview150;

import binary_search.ListNode;

/**
 * @Author Curtain
 * @Date 2023/10/30 16:00
 * @Description
 */
public class T21 {
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tmp = head;
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                tmp.next = list1;
                list1 = list1.next;
            }else {
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = list1 != null ? list1 : list2;
        return head.next;
    }
}
