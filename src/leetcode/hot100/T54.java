package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/8/24 13:38
 * @Description
 */
public class T54 {
    
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(new T54().spiralOrder(matrix));
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int i = 0;
        int j = 0;
         while (true){
             result.add(matrix[i][j]);
             matrix[i][j] = 200;
             //有上，无左
             if (i >= 1 && matrix[i - 1][j] != 200 && (j <= 0 || matrix[i][j - 1] == 200)){
                 i--;
                 continue;
                 //有右无上
             }else if ((i <= 0 || matrix[i - 1][j] == 200) && j + 1 < colLength && matrix[i][j + 1] != 200){
                 j++;
                 continue;
                 //有下无右
             }else if ((j + 1 >= colLength || matrix[i][j + 1] == 200) && i + 1 < rowLength && matrix[i + 1][j] !=200){
                 i++;
                 continue;
                 //有左无下
             }else if (j - 1 >= 0 && matrix[i][j - 1] != 200 && (i + 1 >= rowLength || matrix[i + 1][j] ==200)){
                 j--;
                 continue;
             }else {
                 break;
             }
         }
        return result;
    }
}
