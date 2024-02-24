package leetcode.everyday;

/**
 * @Author Curtain
 * @Date 2023/8/13 14:45
 * @Description
 */
public class T88 {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = n + m - 1;
        while (i >= 0 && j >= 0){
            if (nums1[i] > nums2[j]){
                nums1[index--] = nums1[i];
                i--;
            }else {
                nums1[index--] = nums2[j];
                j--;
            }
        }
        while (j >= 0){
            nums1[index--] = nums2[j--];
        }
    }
}
