package leetcode.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Curtain
 * @Date 2023/9/6 17:20
 * @Description
 */
public class T102 {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       while (!queue.isEmpty()){
           Queue<TreeNode> nextLevelQueue = new LinkedList<>();
           List<Integer> list = new ArrayList<>();
           while (!queue.isEmpty()){
               TreeNode poll = queue.poll();
               list.add(poll.val);
               if (poll.left != null){
                   nextLevelQueue.offer(poll.left);
               }
               if (poll.right != null){
                   nextLevelQueue.offer(poll.right);
               }
           }
           result.add(list);
           queue = nextLevelQueue;
       }
        return result;
    }
}
