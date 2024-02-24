package leetcode.everyday;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author Curtain
 * @Date 2023/12/21 10:47
 * @Description
 * 给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。
 *
 * 你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。
 *
 * 如果以下条件满足，我们称这些塔是 美丽 的：
 *
 * 1 <= heights[i] <= maxHeights[i]
 * heights 是一个 山脉 数组。
 * 如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山脉 数组：
 *
 * 对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j]
 * 对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k]
 * 请你返回满足 美丽塔 要求的方案中，高度和的最大值 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：maxHeights = [5,3,4,1,1]
 * 输出：13
 * 解释：和最大的美丽塔方案为 heights = [5,3,3,1,1] ，这是一个美丽塔方案，因为：
 * - 1 <= heights[i] <= maxHeights[i]  
 * - heights 是个山脉数组，峰值在 i = 0 处。
 * 13 是所有美丽塔方案中的最大高度和。
 * 示例 2：
 *
 * 输入：maxHeights = [6,5,3,9,2,7]
 * 输出：22
 * 解释： 和最大的美丽塔方案为 heights = [3,3,3,9,2,2] ，这是一个美丽塔方案，因为：
 * - 1 <= heights[i] <= maxHeights[i]
 * - heights 是个山脉数组，峰值在 i = 3 处。
 * 22 是所有美丽塔方案中的最大高度和。
 * 示例 3：
 *
 * 输入：maxHeights = [3,2,5,5,2,3]
 * 输出：18
 * 解释：和最大的美丽塔方案为 heights = [2,2,5,5,2,2] ，这是一个美丽塔方案，因为：
 * - 1 <= heights[i] <= maxHeights[i]
 * - heights 是个山脉数组，最大值在 i = 2 处。
 * 注意，在这个方案中，i = 3 也是一个峰值。
 * 18 是所有美丽塔方案中的最大高度和。
 *
 *
 * 提示：
 *
 * 1 <= n == maxHeights <= 10^5
 * 1 <= maxHeights[i] <= 10^9
 */
public class T2866 {
    
    public static void main(String[] args) {
        System.out.println(new T2866().maximumSumOfHeights(Arrays.asList(5, 3, 4, 1, 1)));
    }
    
    public long maximumSumOfHeights(List<Integer> maxHeights){
        Stack<Integer> stack = new Stack<>();
        long[] suf = new long[maxHeights.size() + 1];
        stack.push(maxHeights.size());
        long sum = 0;
        for (int i = maxHeights.size() - 1; i >= 0; i--) {
            long val = maxHeights.get(i);
            while (stack.size() > 1 && val <= maxHeights.get(stack.peek())){
                int index = stack.pop();
                sum -= (long) maxHeights.get(index) * (stack.peek() - index);
            }
            sum += val * (stack.peek() - i);
            suf[i] = sum;
            stack.push(i);
        }
        long ans = sum;
        stack.clear();
        sum = 0;
        stack.push(-1);
        for (int i = 0; i < maxHeights.size(); i++) {
            long val = maxHeights.get(i);
            while (stack.size() > 1 && val <= maxHeights.get(stack.peek())){
                int index = stack.pop();
                sum -= (long) maxHeights.get(index) * (index - stack.peek());
            }
            sum += val * (i - stack.peek());
            stack.push(i);
            ans = Math.max(ans, sum + suf[i + 1]);
        }
        return ans;
    }
    
    //超时
//    public long maximumSumOfHeights(List<Integer> maxHeights) {
//        long ans = Long.MIN_VALUE;
//        long[] lefts = new long[maxHeights.size()];
//        long[] rights = new long[maxHeights.size()];
//        //计算lefts
//        lefts[0] = maxHeights.get(0);
//        for (int i = 1; i < maxHeights.size(); i++) {
//            long base = maxHeights.get(i);
//            for (int j = i - 1; j >= 0; j--) {
//                if (maxHeights.get(i) > maxHeights.get(j)){
//                    lefts[i] = base + lefts[j];
//                    break;
//                }else{
//                    base += maxHeights.get(i);
//                    if (j == 0){
//                        lefts[i] = base;
//                    }
//                }
//            }
//            
//        }
//        //计算rights
//        rights[maxHeights.size() - 1] = maxHeights.get(maxHeights.size() - 1);
//        for (int i = maxHeights.size() - 2; i >= 0; i--) {
//            long base = maxHeights.get(i);
//            for (int j = i + 1; j < maxHeights.size(); j++) {
//                if (maxHeights.get(i) > maxHeights.get(j)){
//                    rights[i] = base + rights[j];
//                    break;
//                }else{
//                    base += maxHeights.get(i);
//                    if (j == maxHeights.size() - 1){
//                        rights[i] = base;
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < maxHeights.size(); i++) {
//            ans = Math.max(ans, rights[i] + lefts[i] - maxHeights.get(i));
//        }
//        return ans;
//    }
    //超时
//    public long maximumSumOfHeights(List<Integer> maxHeights) {
//        Long ans = Long.MIN_VALUE;
//        //将每个点作为山峰
//        for (int i = 0; i < maxHeights.size(); i++) {
//            Long total = Long.valueOf(maxHeights.get(i));
//            //山峰向左
//            Integer maxHeight = maxHeights.get(i);
//            for (int j = i - 1; j >= 0; j--) {
//                maxHeight = Math.min(maxHeight, maxHeights.get(j));
//                total += maxHeight;
//            }
//            //从山峰往右
//            maxHeight = maxHeights.get(i);
//            for (int j = i + 1; j < maxHeights.size(); j++) {
//                maxHeight = Math.min(maxHeight, maxHeights.get(j));
//                total += maxHeight;
//            }
//            ans = Math.max(ans, total);
//        }
//        return ans;
//    }
}
