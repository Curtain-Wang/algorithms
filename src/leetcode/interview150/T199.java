package leetcode.interview150;

import leetcode.hot100.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/11/23 11:05
 * @Description
 */
public class T199 {
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null){
//            return result;
//        }
//        Deque<TreeNode> deque = new ArrayDeque<>();
//        Deque<TreeNode> deque1 = new ArrayDeque<>();
//        deque.addLast(root);
//        
//        while (!deque.isEmpty()){
//            TreeNode poll = deque.poll();
//            if (poll.left != null){
//                deque1.addLast(poll.left);
//            }
//            if (poll.right != null){
//                deque1.addLast(poll.right);
//            }
//            if (deque.isEmpty()){
//                result.add(poll.val);
//                deque = deque1;
//                deque1 = new ArrayDeque<>();
//            }
//        }
//        return result;
//    }
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left != null){
                    deque.addLast(poll.left);
                }
                if (poll.right != null){
                    deque.addLast(poll.right);
                }
                if (i == size - 1){
                    result.add(poll.val);
                }
            }
        }
        return result;
    }
    
}
