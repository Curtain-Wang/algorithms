package leetcode.everyday;

/**
 * @Author Curtain
 * @Date 2023/10/9 13:08
 * @Description
 */
public class T2578_1 {
    public int splitNum(int num) {
        int[] count = new int[10];
        int n = 0;
        while (num > 0){
            count[num % 10]++;
            num /= 10;
            n++;
        }
        int[] splitNums = new int[2];
        for (int i = 0, j = 0; i < n; i++) {
            while (count[j] == 0){
                j++;
            }
            count[j]--;
            splitNums[i & 1] = splitNums[i & 1] * 10 + j;
        }
        return splitNums[0] + splitNums[1];
    }
}
