package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/8/23 16:24
 * @Description
 */
public class T73 {
    
    public void setZeroes(int[][] matrix) {
        boolean row0Flag = false;
        boolean col0Flag = false;
        //判断第一行是否有0
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0){
                row0Flag = true;
                break;
            }
        }
        //判断第一列是否有0
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0){
                col0Flag = true;
                break;
            }
            
        }
        //给标志位赋值
        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //根据标志位置0
        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if (col0Flag){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (row0Flag){
            for (int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
    }
}
