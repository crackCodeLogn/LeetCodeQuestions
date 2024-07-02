package leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-07-02
 */
public class Q350_E_IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        Q350_E_IntersectionOfTwoArraysII q350EIntersectionOfTwoArraysII = new Q350_E_IntersectionOfTwoArraysII();
        System.out.println(Arrays.toString(q350EIntersectionOfTwoArraysII.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}))); // 2,2
        System.out.println(Arrays.toString(q350EIntersectionOfTwoArraysII.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}))); // 4,9
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0, p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            while (p1 < nums1.length && nums1[p1] < nums2[p2]) p1++;
            if (p1 == nums1.length) break;
            while (p2 < nums2.length && nums2[p2] < nums1[p1]) p2++;
            if (p2 == nums2.length) break;
            while (p1 < nums1.length && p2 < nums2.length && nums1[p1] == nums2[p2]) {
                list.add(nums1[p1]);
                p1++;
                p2++;
            }
        }

        int[] data = new int[list.size()];
        for (int i = 0; i < list.size(); i++) data[i] = list.get(i);
        return data;
    }
}
