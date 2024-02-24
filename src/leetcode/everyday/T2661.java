package leetcode.everyday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/12/1 10:26
 * @Description
 *
 * 提示：
 *
 * m == mat.length
 * n = mat[i].length
 * arr.length == m * n
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * 1 <= arr[i], mat[r][c] <= m * n
 * arr 中的所有整数 互不相同
 * mat 中的所有整数 互不相同
 */
public class T2661 {
    
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];
        Arrays.fill(rows, mat[0].length);
        Arrays.fill(cols, mat.length);
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int[] ints = map.get(arr[i]);
            if (--rows[ints[0]] == 0){
                return i;
            }
            if (--cols[ints[1]] == 0){
                return i;
            }
        }
        return -1;
    }
}
