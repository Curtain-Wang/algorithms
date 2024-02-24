package leetcode.everyday;

import com.sun.corba.se.impl.interceptors.PICurrent;

/**
 * @Author Curtain
 * @Date 2023/8/17 16:48
 * @Description 切披萨的方案数
 * <p>
 * 给你一个 rows x cols 大小的矩形披萨和一个整数 k ，矩形包含两种字符： 'A' （表示苹果）和 '.' （表示空白格子）。你需要切披萨 k-1 次，得到 k 块披萨并送给别人。
 * <p>
 * 切披萨的每一刀，先要选择是向垂直还是水平方向切，再在矩形的边界上选一个切的位置，将披萨一分为二。如果垂直地切披萨，那么需要把左边的部分送给一个人，如果水平地切，那么需要把上面的部分送给一个人。在切完最后一刀后，需要把剩下来的一块送给最后一个人。
 * <p>
 * 请你返回确保每一块披萨包含 至少 一个苹果的切披萨方案数。由于答案可能是个很大的数字，请你返回它对 10^9 + 7 取余的结果。
 * 1 <= rows, cols <= 50
 * rows == pizza.length
 * cols == pizza[i].length
 * 1 <= k <= 10
 * pizza 只包含字符 'A' 和 '.' 。
 */
public class T1444 {
    
    public static void main(String[] args) {
        String[] pizza = {"A..","A..","..."};
        System.out.println(new T1444().ways(pizza, 1));
    }
    
    public int ways(String[] pizza, int k) {
        int[] result = new int[1];
        handle(pizza, 0, 0, k - 1, result);
        return result[0];
    }
    
    private void handle(String[] pizza, int startRow, int startCol, int remainCuts, int[] result) {
        //瓜分失败
        if (startRow == pizza.length || startCol == pizza[0].length()) {
            return;
        }
        //判断最后一块披萨里面有没有樱桃
        if (remainCuts == 0) {
            for (int i = startRow; i < pizza.length; i++) {
                for (int j = startCol; j < pizza[0].length(); j++) {
                    if (pizza[i].charAt(j) == 'A') {
                        result[0] = result[0] + 1;
                        if (result[0] == 1000000007) {
                            result[0] = 0;
                        }
                        return;
                    }
                }
            }
            return;
        }
        //横切
        int row = startRow;
        while (row < pizza.length - 1) {
            for (int i = startCol; i < pizza[0].length(); i++) {
                if (pizza[row].charAt(i) == 'A'){
                    while (row < pizza.length - 1) {
                        handle(pizza, ++row, startCol, remainCuts - 1, result);
                    }
                }
            }
            row++;
        }
        //竖切
        int col = startCol;
        while (col < pizza[0].length() - 1) {
            for (int i = startRow; i < pizza.length; i++) {
                if (pizza[i].charAt(col) == 'A') {
                    //继续切
                    while (col < pizza[0].length() - 1){
                        handle(pizza, startRow, ++col, remainCuts - 1, result);
                    }
                    break;
                }
            }
            col++;
        }
    }
}
