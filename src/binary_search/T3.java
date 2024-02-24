package binary_search;

/**
 * @Author Curtain
 * @Date 2023/6/29 19:57
 * @Description
 */
public class T3 {
    
    
    public int squareRoot(int a){
        int left = 1;
        int right = a;
        while(left <= right){
            int mid = (left + right) / 2;
            if (mid == a / mid){
                return mid;
            }
            if (mid < a / mid){
                if ((mid + 1) > a / (mid + 1)){
                    return mid;
                }
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
