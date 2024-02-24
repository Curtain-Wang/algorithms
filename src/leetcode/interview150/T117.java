package leetcode.interview150;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Curtain
 * @Date 2023/11/15 9:46
 * @Description
 */
public class T117 {
    
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        queue1.add(root);
        Node prev = null;
        while (!queue1.isEmpty()){
            Node poll = queue1.poll();
            if (prev != null){
                prev.next = poll;
            }
            if (poll.left != null){
                queue2.add(poll.left);
            }
            if (poll.right != null){
                queue2.add(poll.right);
            }
            prev = poll;
            if (queue1.isEmpty()){
                queue1 = queue2;
                prev = null;
                queue2 = new LinkedList<>();
            }
        }
        return root;
    }
    
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        
        public Node() {
        }
        
        public Node(int _val) {
            val = _val;
        }
        
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
