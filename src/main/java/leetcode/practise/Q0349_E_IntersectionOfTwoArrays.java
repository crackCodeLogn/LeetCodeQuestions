package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-03-10
 */
public class Q0349_E_IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] data = new int[1000];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) if (data[nums1[i]] == 0) data[nums1[i]]++;
        for (int i = 0; i < nums2.length; i++)
            if (data[nums2[i]] == 1) {
                res.add(nums2[i]);
                data[nums2[i]]++;
            }
        int[] res1 = new int[res.size()];
        for (int i = 0; i < res1.length; i++) res1[i] = res.get(i);
        return res1;
    }
}
