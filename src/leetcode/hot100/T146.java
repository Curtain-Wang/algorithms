package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/9/1 9:19
 * @Description
 */
public class T146 {
    
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2,1);
        lruCache.get(2);
        lruCache.put(3,2);
        lruCache.get(2);
        lruCache.get(3);
    }
    
    static class LRUCache {
    
        private int capacity;
        private Map<Integer, BothwayNode> nodeMap = new HashMap<>();
        private Map<BothwayNode, Integer> keyMap = new HashMap<>();
        private BothwayNode dummy;
        private int lastNodeKey;
    
        public LRUCache(int capacity) {
            this.capacity = capacity;
            dummy = new BothwayNode();
        }
    
        public int get(int key) {
            BothwayNode bothwayNode = nodeMap.get(key);
            if (bothwayNode == null){
                return -1;
            }else {
                moveToFront(bothwayNode);
                return bothwayNode.val;
            }
        }
    
        public void put(int key, int value) {
            BothwayNode node = nodeMap.get(key);
            //新节点
            if (node == null){
                node = new BothwayNode(value);
                //放入hash表
                nodeMap.put(key, node);
                keyMap.put(node, key);
                //加入链表
                BothwayNode next = dummy.next;
                dummy.next = node;
                node.next = next;
                node.prev = dummy;
                if (next != null){
                    next.prev = node;
                }
                //当前节点是第一个节点也是最后一个节点
                if (nodeMap.size() == 1){
                    lastNodeKey = key;
                }else if (nodeMap.size() == capacity + 1){
                    //需要删除最后一个节点
                    BothwayNode lastNode = nodeMap.get(lastNodeKey);
                    BothwayNode prevNode = lastNode.prev;
                    //删除hash表
                    keyMap.remove(lastNode);
                    nodeMap.remove(lastNodeKey);
                    //链表上删除最后一个节点
                    prevNode.next = null;
                    //更新最后一个节点信息
                    lastNodeKey = keyMap.get(prevNode);
                }
            }else {
                //老节点
                node.val = value;
                moveToFront(node);
            }
        }
    
        private void moveToFront(BothwayNode node){
            //原本就在链表头部 就不用移动
            if (node.prev == dummy){
                return;
            }
            //保存原来位置的前后节点
            BothwayNode prevNode = node.prev;
            BothwayNode nextNode = node.next;
            //将当前节点移到链表头部
            BothwayNode tmp = dummy.next;
            dummy.next = node;
            node.prev = dummy;
            node.next = tmp;
            if (tmp != null){
                tmp.prev = node;
            }
            //将原来位置的前后节点连接起来
            prevNode.next = nextNode;
            if (nextNode != null){
                nextNode.prev = prevNode;
            }
            //判断原来位置是不是最后位置，如果是 则更新最后位置
            if (lastNodeKey == keyMap.get(node) && nodeMap.size() > 1){
                lastNodeKey = keyMap.get(prevNode);
            }
        }
    }
    
    static class BothwayNode {
        int val;
        BothwayNode next;
        BothwayNode prev;
        
        BothwayNode() {
        }
        
        BothwayNode(int val) {
            this.val = val;
        }
    }
    
}




