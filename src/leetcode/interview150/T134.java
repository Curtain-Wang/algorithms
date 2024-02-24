package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/10/9 9:29
 * @Description
 * 
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 *
 *
 *
 * 示例 1:
 *
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 *
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 *
 *
 * 提示:
 *
 * gas.length == n
 * cost.length == n
 * 1 <= n <= 10^5
 * 0 <= gas[i], cost[i] <= 10^4
 */
public class T134 {
    
    //超时
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int length = gas.length;
//        //从i出发
//        for (int i = 0; i < length; i++) {
//            int remainOil = 0;
//            for (int j = 0; j < length; j++) {
//                remainOil += gas[(i + j) % length] - cost[(i + j) % length];
//                //从i出发，不满足。
//                if (remainOil <= 0){
//                    break;
//                }
//                if (j == length - 1){
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
    
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int length = gas.length;
//        int[] remainOil = new int[length];
//        for (int i = 0; i < length; i++) {
//            remainOil[i] = gas[i] - cost[i];
//        }
//        if (length == 1){
//            return remainOil[0] >= 0 ? 0 : -1;
//        }
//        for (int i = 0; i < length; i++) {
//            if (remainOil[i] <= 0){
//                continue;
//            }
//            int remain = 0;
//            for (int j = 0; j < length; j++) {
//                remain += remainOil[(i + j) % length];
//                if (remain < 0){
//                    break;
//                }
//                if (j == length - 1){
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remain = 0;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            remain += gas[i] - cost[i];
            if (remain < min){
                min = remain;
                minIndex = i;
            }
        }
        if (min >= 0){
            return 0;
        }
        return remain >= 0 ? (minIndex + 1) % cost.length : -1;
    }
}
