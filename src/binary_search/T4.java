package binary_search;

/**
 * @Author Curtain
 * @Date 2023/6/29 20:10
 * @Description
 */
public class T4 {
    
    
    private int minEatingSpeed(int[] piles, int h){
        int left = 1;
        int right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left <= right){
            int mid = left + (right - left) / 2;
            int hour = getHours(mid, piles);
            if (hour <= h){
                if (mid == 1 || getHours(mid - 1, piles) > h){
                    return mid;
                }
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
    
    private int getHours(int mid, int[] piles) {
        int hour = 0;
        for (int pile : piles) {
            if (pile % mid == 0){
                hour += pile / mid;
            }else {
                hour += pile / mid + 1;
            }
        }
        return hour;
    }
}
