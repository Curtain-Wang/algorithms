package leetcode.hot100;

import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/8/15 9:16
 * @Description 删除链表的倒数第 N 个结点
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class T19 {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 0;
        int j = 0;
        ListNode nodeJ = head;
        ListNode nodeI = head;
        while (nodeJ.next != null){
            if (j - i == n){
                nodeI = nodeI.next;
                i++;
            }
            nodeJ = nodeJ.next;
            j++;
        }
        if (j - i == n){
            //此刻nodeI在倒数第n + 1的位置
            ListNode delNode = nodeI.next;
            nodeI.next = delNode.next;
            delNode.next = null;
        }else {
            //找不到倒数n + 1的位置 根据题目，删除的应该是第一个位置
            ListNode tmpNode = head.next;
            head.next = null;
            head = tmpNode;
        }
        return head;
    }
}

class ListNode {
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
 
