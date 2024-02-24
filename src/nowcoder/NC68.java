package nowcoder;

/**
 * @Author Curtain
 * @Date 2024/2/23 11:25
 * @Description
 * 
 * 描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 数据范围：
 * 1
 * ≤
 * �
 * ≤
 * 40
 * 1≤n≤40
 * 要求：时间复杂度：
 * �
 * (
 * �
 * )
 * O(n) ，空间复杂度： 
 * �
 * (
 * 1
 * )
 * O(1)
 * 示例1
 * 输入：
 * 2
 * 复制
 * 返回值：
 * 2
 * 复制
 * 说明：
 * 青蛙要跳上两级台阶有两种跳法，分别是：先跳一级，再跳一级或者直接跳两级。因此答案为2       
 * 示例2
 * 输入：
 * 7
 * 复制
 * 返回值：
 * 21
 */
public class NC68 {
    
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param number int整型 
     * @return int整型
     */
    public int jumpFloor (int number) {
        // write code here
        return jump(0, number);
    }
    
    private int jump(int i, int number) {
        if (i > number){
            return 0;
        }else if (i == number){
            return 1;
        }else {
            return jump(i + 1, number) + jump(i + 2, number);
        }
    }
}
