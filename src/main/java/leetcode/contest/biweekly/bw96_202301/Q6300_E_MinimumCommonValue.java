package leetcode.contest.biweekly.bw96_202301;

/**
 * @author Vivek
 * @since 2023-01-21
 */
public class Q6300_E_MinimumCommonValue {

    public static void main(String[] args) {
        Q6300_E_MinimumCommonValue q6300EMinimumCommonValue = new Q6300_E_MinimumCommonValue();
        System.out.println(q6300EMinimumCommonValue.getCommon(new int[]{
                3, 10, 40
        }, new int[]{
                1, 2, 50, 60, 65, 67, 78, 80, 90, 95, 100
        }));
    }

    public int getCommon(int[] nums1, int[] nums2) {
        int ptr1 = 0, ptr2 = 0;
        while (nums1[ptr1] != nums2[ptr2]) {
            while (ptr1 < nums1.length && nums1[ptr1] < nums2[ptr2]) ptr1++;
            if (ptr1 >= nums1.length) return -1;
            while (ptr2 < nums2.length && nums2[ptr2] < nums1[ptr1]) ptr2++;
            if (ptr2 >= nums2.length) return -1;
        }
        return nums2[ptr2];
    }
}
