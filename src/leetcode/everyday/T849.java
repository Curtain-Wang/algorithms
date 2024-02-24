package leetcode.everyday;

/**
 * @Author Curtain
 * @Date 2023/8/22 11:28
 * @Description 到最近的人的最大距离
 */
public class T849 {
    
    public static void main(String[] args) {
        int[] seats = {1,0,0,0};
        System.out.println(new T849().maxDistToClosest(seats));
    }
    
    public int maxDistToClosest(int[] seats) {
        int lastIndex = -1;
        int maxLength = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1){
                maxLength = lastIndex == -1 ? Math.max(maxLength, (i - lastIndex - 1) * 2) : Math.max(maxLength, i - lastIndex);
                lastIndex = i;
            }
        }
        maxLength = Math.max(maxLength, (seats.length - lastIndex - 1) * 2);
        return maxLength / 2;
    }
}
