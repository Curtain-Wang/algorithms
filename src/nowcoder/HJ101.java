package nowcoder;

import java.util.Scanner;

/**
 * @Author Curtain
 * @Date 2024/2/23 15:52
 * @Description
 * 
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 *
 * 数据范围：
 * 1≤n≤1000  ，元素大小满足
 * 0≤val≤100000 
 * 输入描述：
 * 第一行输入数组元素个数
 * 第二行输入待排序的数组，每个数用空格隔开
 * 第三行输入一个整数0或1。0代表升序排序，1代表降序排序
 *
 * 输出描述：
 * 输出排好序的数字
 */
public class HJ101 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        String s = in.nextLine();
        int sort = Integer.valueOf(in.nextLine());
        String[] split = s.split(" ");
        int[] arr = new int[100001];
        for (String i : split) {
            arr[Integer.valueOf(i)]++;
        }
        if (sort == 0){
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i]; j++) {
                    System.out.print(i + " ");
                }
            }
        }else {
            for (int i = arr.length - 1; i >= 0; i--) {
                for (int j = 0; j < arr[i]; j++) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
