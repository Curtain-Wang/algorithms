package leetcode.interview150;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Curtain
 * @Date 2024/1/2 10:11
 * @Description
 * 假设 力扣（LeetCode）即将开始 IPO 。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 
 * 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
 *
 * 给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。
 *
 * 最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 *
 * 总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。
 *
 * 答案保证在 32 位有符号整数范围内。
 * 示例 1：
 *
 * 输入：k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
 * 输出：4
 * 解释：
 * 由于你的初始资本为 0，你仅可以从 0 号项目开始。
 * 在完成后，你将获得 1 的利润，你的总资本将变为 1。
 * 此时你可以选择开始 1 号或 2 号项目。
 * 由于你最多可以选择两个项目，所以你需要完成 2 号项目以获得最大的资本。
 * 因此，输出最后最大化的资本，为 0 + 1 + 3 = 4。
 * 示例 2：
 *
 * 输入：k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
 * 输出：6
 */
public class T502 {
    public static void main(String[] args) {
        System.out.println(new T502().findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}));
    }
    
    /**
     * 贪心 + 优先队列（堆）
     * 由于每完成一个任务都会使得总资金 w 增加或不变。因此对于所选的第 i 个任务而言，应该在所有「未被选择」且启动资金不超过 w 的所有任务里面选利润最大的。
     *
     * 可通过「归纳法」证明每次都在所有候选中选择利润最大的任务，可使得总资金最大。
     *
     * 对于第 i 次选择而言（当前所有的资金为 w），如果选择的任务利润为 cur，而实际可选的最大任务利润为 max（ cur<=max）。
     *
     * 将「选择 cur」调整为「选择 max」，结果不会变差：
     *
     * 根据传递性，由 cur<=max 可得 w+cur<=w+max，可推导出调整后的总资金不会变少；
     * 利用推论 1，由于总资金相比调整前没有变少，因此后面可选择的任务集合也不会变少。这意味着 至少可以维持 第 i 次选择之后的所有原有选择。
     * 至此，我们证明了将每次的选择调整为选择最大利润的任务，结果不会变差。
     *
     * 当知道了「每次都应该在所有可选择的任务里选利润最大」的推论之后，再看看算法的具体流程。
     *
     * 由于每完成一个任务总资金都会 增大/不变，因此所能覆盖的任务集合数量也随之 增加/不变 。
     *
     * 因此算法核心为「每次决策前，将启动资金不超过当前总资金的任务加入集合，再在里面取利润最大的任务」。
     *
     * 「取最大」的过程可以使用优先队列（根据利润排序的大根堆），而「将启动资金不超过当前总资金的任务加入集合」的操作，可以利用总资金在整个处理过程递增，而先对所有任务进行预处理排序来实现。
     *
     * 具体的，我们可以按照如下流程求解：
     *
     * 根据 profits 和 capital 预处理出总的任务集合二元组，并根据「启动资金」进行升序排序；
     *
     * 每次决策前，将所有的启动资金不超过 w 的任务加入优先队列（根据利润排序的大根堆），然后从优先队列（根据利润排序的大根堆），将利润累加到 w；
     *
     * 循环步骤 2，直到达到 k 个任务，或者队列为空（当前资金不足以选任何任务）。
     * @param k
     * @param w
     * @param profits
     * @param capital
     * @return
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            list.add(new int[]{profits[i], capital[i]});
        }
        //根据成本升序
        Collections.sort(list, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int i = 0;
        while (k > 0){
            while (i < n && list.get(i)[1] <= w){
                queue.add(list.get(i++)[0]);
            }
            if (!queue.isEmpty()){
                w += queue.poll();
            }
            k--;
        }
        return w;
    }
}
