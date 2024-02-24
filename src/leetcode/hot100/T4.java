package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/18 13:23
 * @Description
 */
public class T4 {
    int length1 = 0;
    int length2 = 0;
    
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1};
        System.out.println(new T4().findMedianSortedArrays(nums1, nums2));
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        length1 = nums1.length;
        length2 = nums2.length;
        int mid = (length1 + length2) / 2;
        if ((length1 + length2) % 2 == 0){
            return (getKthElement(nums1, nums2, mid) + getKthElement(nums1, nums2, mid + 1)) / 2;
        }else {
            return getKthElement(nums1, nums2, mid + 1);
        }
    }
    
    
    public double getKthElement(int[] nums1, int[] nums2, int k){
        int index1 = 0;
        int index2 = 0;
        while (true){
            if (index1 == length1){
                return nums2[index2 + k - 1];
            }
            if (index2 == length2){
                return nums1[index1 + k - 1];
            }
            if (k == 1){
                return nums1[index1] > nums2[index2] ? nums2[index2] : nums1[index1];
            }
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            if (nums1[newIndex1] < nums2[newIndex2]){
                k -= newIndex1 - index1 + 1;
                index1 = newIndex1 + 1;
            }else {
                k -= newIndex2 - index2 + 1;
                index2 = newIndex2 + 1;
            }
        }
    }
}
