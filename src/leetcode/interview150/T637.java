package leetcode.interview150;

import leetcode.hot100.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Curtain
 * @Date 2023/11/10 16:51
 * @Description
 */
public class T637 {
    
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue.add(root);
        double sum = 0.0;
        double count = 0.0;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            sum += poll.val;
            if (poll.left != null){
                queue1.add(poll.left);
            }
            if (poll.right != null){
                queue1.add(poll.right);
            }
            count++;
            if (queue.isEmpty()){
                queue = queue1;
                queue1 = new LinkedList<>();
                result.add(sum /  count);
                count = 0.0;
                sum = 0.0;
            }
        }
        return result;
    }
}
