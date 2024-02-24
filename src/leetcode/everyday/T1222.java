package leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/9/14 11:23
 * @Description
 */
public class T1222 {
    //       0      1     2        3       4        5      6       7
    List leftTop, top, rightTop, right, lowRight, low, lowLeft, left;
    
    List<Integer>[] attacks = new List[8];
    
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        for (int[] queen : queens) {
            //同一列
            if (queen[1] == king[1]) {
                //上
                if (queen[0] < king[0]) {
                    //todo
                    if (attacks[1] == null || attacks[1].get(0) < queen[0]) {
                        fill(1, queen[0], queen[1]);
                    }
                }
                //下
                if (queen[0] > king[0]) {
                    if (attacks[5] == null || attacks[5].get(0) > queen[0]) {
                        fill(5, queen[0], queen[1]);
                    }
                }
            }
            //同一行
            if (queen[0] == king[0]) {
                //左
                if (queen[1] < king[1]) {
                    if (attacks[7] == null || attacks[7].get(1) < queen[1]) {
                        fill(7, queen[0], queen[1]);
                    }
                }
                //右
                if (queen[1] > king[1]) {
                    if (attacks[3] == null || attacks[3].get(1) > queen[1]) {
                        fill(3, queen[0], queen[1]);
                    }
                }
            }
            //对角
            if (Math.abs(queen[0] - king[0]) == Math.abs(queen[1] - king[1])) {
                //左对角
                if (queen[1] < king[1]) {
                    //左上
                    if (queen[0] < king[0]) {
                        if (attacks[0] == null || queen[1] > attacks[0].get(1)) {
                            fill(0, queen[0], queen[1]);
                        }
                    }
                    //左下
                    if (queen[0] > king[0]) {
                        if (attacks[6] == null || queen[1] > attacks[6].get(1)) {
                            fill(6, queen[0], queen[1]);
                        }
                    }
                }
                //右对角
                if (queen[1] > king[1]) {
                    //右上
                    if (queen[0] < king[0]) {
                        if (attacks[2] == null || queen[1] < attacks[2].get(1)) {
                            fill(2, queen[0], queen[1]);
                        }
                    }
                    //右下
                    if (queen[0] > king[0]) {
                        if (attacks[4] == null || queen[1] < attacks[4].get(1)) {
                            fill(4, queen[0], queen[1]);
                        }
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> attack : attacks) {
            if (attack != null) {
                result.add(attack);
            }
        }
        return result;
    }
    
    private void fill(int index, int i, int j) {
        if (attacks[index] != null){
            attacks[index].clear();
        }else {
            attacks[index] = new ArrayList();
        }
        attacks[index].add(i);
        attacks[index].add(j);
    }
}
