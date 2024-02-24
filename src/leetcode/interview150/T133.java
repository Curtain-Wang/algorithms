package leetcode.interview150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/11/28 19:35
 * @Description
 */
public class T133 {
    
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        List<Node> list1 = new ArrayList<>();
        list1.add(node2);list1.add(node4);node1.neighbors = list1;
        List<Node> list2 = new ArrayList<>();
        list2.add(node1);list2.add(node3);node2.neighbors = list2;
        List<Node> list3 = new ArrayList<>();
        list3.add(node2);list3.add(node4);node3.neighbors = list3;
        List<Node> list4 = new ArrayList<>();
        list4.add(node1);list4.add(node3);node4.neighbors = list4;
        new T133().cloneGraph(node1);
    }
    
    HashMap<Integer, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        return dfs(node);
    }
    
    private Node dfs(Node node) {
        if (node == null){
            return null;
        }
        //已经有了
        if (map.get(node.val) != null){
            return map.get(node.val);
        }
        Node newNode = new Node(node.val);
        map.put(node.val, newNode);
        List<Node> newNeighbors = new ArrayList<>();
        newNode.neighbors = newNeighbors;
        for (Node neighbor : node.neighbors) {
            newNeighbors.add(dfs(neighbor));
        }
        return newNode;
    }
    
    static class Node {
        public int val;
        public List<Node> neighbors;
        
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
