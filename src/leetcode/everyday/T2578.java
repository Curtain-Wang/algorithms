package leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/10/9 11:09
 * @Description
 * 
 * 给你一个正整数 num ，请你将它分割成两个非负整数 num1 和 num2 ，满足：
 *
 * num1 和 num2 直接连起来，得到 num 各数位的一个排列。
 * 换句话说，num1 和 num2 中所有数字出现的次数之和等于 num 中所有数字出现的次数。
 * num1 和 num2 可以包含前导 0 。
 * 请你返回 num1 和 num2 可以得到的和的 最小 值。
 *
 * 注意：
 * num 保证没有前导 0 。
 * num1 和 num2 中数位顺序可以与 num 中数位顺序不同。
 * 
 * 示例 1：
 *
 * 输入：num = 4325
 * 输出：59
 * 解释：我们可以将 4325 分割成 num1 = 24 和 num2 = 35 ，和为 59 ，59 是最小和。
 * 示例 2：
 *
 * 输入：num = 687
 * 输出：75
 * 解释：我们可以将 687 分割成 num1 = 68 和 num2 = 7 ，和为最优值 75 。
 *
 *
 * 提示：
 *
 * 10 <= num <= 10^9
 */
public class T2578 {
    
    public int splitNum(int num) {
        List<Integer> numList = new ArrayList<>();
        while (num > 0){
            numList.add(num % 10);
            num /= 10;
        }
        numList.sort((i,j) -> i - j);
        int ans = 0;
        for (int i = 0; i < numList.size(); i += 2) {
            ans *= 10;
            ans += numList.get(i);
            if (i + 1 < numList.size()){
                ans += numList.get(i + 1);
            }
        }
        return ans;
    }
}
