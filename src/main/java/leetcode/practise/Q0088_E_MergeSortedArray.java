package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-11-02
 */
public class Q0088_E_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, cur = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) nums1[cur--] = nums1[i--];
            else nums1[cur--] = nums2[j--];
        }
        while (j >= 0) nums1[cur--] = nums2[j--];
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        while (i < m) {
            while (i < m && nums1[i] < nums2[j]) i++;
            if (i == m) {
                while (i < m + n) nums1[i++] = nums2[j++];
                return;
            }
            int t = nums1[i];
            nums1[i] = nums2[j];
            nums2[j] = t;
            j++;
        }
        while (i < m + n) nums1[i++] = nums2[j++];
    }
}
