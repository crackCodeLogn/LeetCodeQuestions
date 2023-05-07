package leetcode.contest.weekly.w344_202305;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vivek
 * @since 2023-05-07
 */
public class Q6416_E_FindTheDistinctDifferenceArray {

    public int[] distinctDifferenceArray(int[] nums) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int[] data = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            set2.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            set1.add(nums[i]);
            set2.remove(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                set2.add(nums[j]);
            }
            data[i] = -set2.size() + set1.size();
        }
        return data;
    }
}
