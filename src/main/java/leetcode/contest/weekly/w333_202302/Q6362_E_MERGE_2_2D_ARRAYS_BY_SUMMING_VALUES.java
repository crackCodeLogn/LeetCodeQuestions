package leetcode.contest.weekly.w333_202302;

import java.util.TreeMap;

/**
 * @author Vivek
 * @since 2023-02-19
 */
public class Q6362_E_MERGE_2_2D_ARRAYS_BY_SUMMING_VALUES {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> map1 = new TreeMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i][0], nums1[i][1]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map1.containsKey(nums2[i][0])) map1.put(nums2[i][0], map1.get(nums2[i][0]) + nums2[i][1]);
            else map1.put(nums2[i][0], nums2[i][1]);
        }
        int[][] data = new int[map1.size()][2];
        int i = 0;
        for (Integer key : map1.keySet()) {
            data[i][0] = key;
            data[i++][1] = map1.get(key);
        }
        return data;
    }
}
