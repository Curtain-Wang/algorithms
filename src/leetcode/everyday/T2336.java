package leetcode.everyday;

/**
 * @Author Curtain
 * @Date 2023/11/29 13:37
 * @Description
 */
public class T2336 {
    class SmallestInfiniteSet {
        int[] nums = null;
        public SmallestInfiniteSet() {
            nums = new int[1000];
        }
        public int popSmallest() {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0){
                    nums[i] = 1;
                    return i + 1;
                }
            }
            return -1;
        }
        public void addBack(int num) {
            nums[num - 1] = 0;
        }
    }
}
