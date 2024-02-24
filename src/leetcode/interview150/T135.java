 package leetcode.interview150;

 import java.util.Arrays;

 /**
 * @Author Curtain
 * @Date 2023/10/9 10:19
 * @Description 分发糖果
 * 
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * 
 * n == ratings.length
 * 1 <= n <= 2 * 10^4
 * 0 <= ratings[i] <= 2 * 10^4
 * 
 * 如果ratings[i] < 
 */
public class T135 {
    
     public static void main(String[] args) {
         int[] ratings = {1, 0, 2};
         new T135().candy(ratings);
         int a = 1;
     }
    
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]){
                candy[i] = candy[i - 1] + 1;
            }
        }
        int sum = candy[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]){
                candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
            }
            sum += candy[i];
        }
        return sum;
    }
    
}
