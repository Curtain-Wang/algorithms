package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/8 14:41
 * @Description
 */
public class T2651 {
    
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) %  24;
    }
}
