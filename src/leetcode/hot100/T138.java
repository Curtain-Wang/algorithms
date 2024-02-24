package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/8/30 9:50
 * @Description
 */
public class T138 {
    public Node copyRandomList(Node head) {
        if (head == null){
            return head;
        }
        //拼接链表
        Node cur = head;
        while (cur != null){
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }
        //给新节点的random赋值
        cur = head;
        while (cur != null){
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        //将节点拆分出来
        Node res = head.next;
        Node newNode = res;
        cur = head;
        while (cur != null){
            cur.next = cur.next.next;
            newNode.next = newNode.next == null ? null : newNode.next.next;
            cur = cur.next;
            newNode = newNode.next;
        }
        return res;
    }
}

class Node {
    int val;
    Node next;
    Node random;
    
    public Node(int val){
        this.val = val;
    }
}
