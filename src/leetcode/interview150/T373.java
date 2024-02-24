package leetcode.interview150;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/12/29 15:06
 * @Description
 * 给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 *
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *      [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 *
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 示例 3:
 *
 * 输入: nums1 = [1,2], nums2 = [3], k = 3 
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 *
 *
 * 提示:
 *
 * 1 <= nums1.length, nums2.length <= 10^5
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1 和 nums2 均为 升序排列
 * 1 <= k <= 10^4
 * k <= nums1.length * nums2.length
 */
public class T373 {
    
    public static void main(String[] args) {
        System.out.println(new T373().kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < Math.min(k, n); i++) {
            queue.add(new int[]{nums1[i] + nums2[0], i, 0});
        }
        while (ans.size() < k && !queue.isEmpty()){
            int[] poll = queue.poll();
            int a = poll[1], b = poll[2];
            List<Integer> list = new ArrayList<>();
            list.add(nums1[a]);
            list.add(nums2[b]);
            ans.add(list);
            if (b + 1 < m){
                queue.add(new int[]{nums1[a] + nums2[b + 1], a, b + 1});
            }
        }
        return ans;
    }
    //超时
//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        List<List<Integer>> ans = new ArrayList<>();
//        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(((o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]));
//        List<Queue<int[]>> list = new ArrayList<>();
//        for (int i = 0; i < nums1.length; i++) {
//            Queue<int[]> queue = new LinkedList<>();
//            for (int j = 0; j < nums2.length; j++) {
//                queue.add(new int[]{i, j});
//            }
//            list.add(queue);
//            priorityQueue.add(queue.poll());
//        }
//        while (k > 0 && !priorityQueue.isEmpty()){
//            List<Integer> demo = new ArrayList<>();
//            int[] poll = priorityQueue.poll();
//            demo.add(nums1[poll[0]]);
//            demo.add(nums2[poll[1]]);
//            ans.add(demo);
//            if (!list.get(poll[0]).isEmpty()){
//                priorityQueue.add(list.get(poll[0]).poll());
//            }
//            k--;
//        }
//        return ans;
//    }
}
