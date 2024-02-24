package leetcode.hot100;

import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/8/15 14:57
 * @Description 合并两个有序链表
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * 
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 */
public class T21 {
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null){
            return list1 == null ? list2 : list1;
        }
        ListNode head = new ListNode();
        ListNode tmp = head;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                tmp.next = list1;
                list1 = list1.next;
            }else {
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }
        if (list1 != null){
            tmp.next = list1;
        }
        if (list2 != null){
            tmp.next = list2;
        }
        return head.next;
    }
}


