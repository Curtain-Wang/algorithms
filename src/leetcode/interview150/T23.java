package leetcode.interview150;

import binary_search.ListNode;

import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/12/25 14:03
 * @Description
 */
public class T23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        int step = 1;
        while (step < lists.length){
            for (int i = step; i < lists.length; i += 2 * step) {
                lists[i - step] = merge(lists[i - step], lists[i]);
            }
            step *= 2;
        }
        return lists[0];
    }
    
    private ListNode merge(ListNode list, ListNode list1) {
        ListNode head = new ListNode();
        ListNode cur = head;
        while (list != null && list1 != null){
            if (list.val < list1.val){
                cur.next = list;
                list = list.next;
            }else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }
        cur.next = list == null ? list1 : list;
        return head.next;
    }
}
