package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/8/28 13:29
 * @Description
 */
public class T160 {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int countNull = 0;
        while (countNull < 2){
            if (nodeA == nodeB){
                return nodeA;
            }
            if (nodeA.next == null){
                countNull++;
            }
            nodeA = nodeA.next == null ? headB : nodeA.next;
            nodeB = nodeB.next == null ? headA : nodeB.next;
        }
        return null;
    }
}
