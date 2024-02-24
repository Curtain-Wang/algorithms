package leetcode.interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/11/15 9:57
 * @Description
 */
public class T117_1 {
    
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        List<Node> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()){
            List<Node> tmp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (i != list.size() - 1){
                    list.get(i).next = list.get(i + 1);
                }
                if (list.get(i).left != null){
                    tmp.add(list.get(i).left);
                }
                if (list.get(i).right != null){
                    tmp.add(list.get(i).right);
                }
            }
            list = tmp;
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
