package leetcode.everyday;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @Author Curtain
 * @Date 2023/9/27 14:52
 * @Description
 * 
 * 给你一个餐馆信息数组 restaurants，其中  restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distancei]。你必须使用以下三个过滤器来过滤这些餐馆信息。
 *
 * 其中素食者友好过滤器 veganFriendly 的值可以为 true 或者 false，如果为 true 就意味着你应该只包括 veganFriendlyi 为 true 的餐馆，为 false 则意味着可以包括任何餐馆。此外，我们还有最大价格 maxPrice 和最大距离 maxDistance 两个过滤器，它们分别考虑餐厅的价格因素和距离因素的最大值。
 *
 * 过滤后返回餐馆的 id，按照 rating 从高到低排序。如果 rating 相同，那么按 id 从高到低排序。简单起见， veganFriendlyi 和 veganFriendly 为 true 时取值为 1，为 false 时，取值为 0 。
 */
public class T1333 {
    
    public static void main(String[] args) {
        int[][] restaurants = new int[][]{{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}};
        System.out.println(new T1333().filterRestaurants(restaurants, 0, 50, 10));
    }
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
                .filter(o -> o[2] >= veganFriendly && o[3] <= maxPrice && o[4] <= maxDistance)
                .sorted((o1, o2) -> o2[1] - o1[1] == 0 ? o2[0] - o1[0] : o2[1] - o1[1])
                .map(o1 -> o1[0])
                .collect(Collectors.toList());
    }
}
