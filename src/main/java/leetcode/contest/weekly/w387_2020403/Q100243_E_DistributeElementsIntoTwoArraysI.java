package leetcode.contest.weekly.w387_2020403;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-03-03
 */
public class Q100243_E_DistributeElementsIntoTwoArraysI {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        l1.add(nums[0]);
        l2.add(nums[1]);
        boolean flag = true;
        for (int i = 2; i < n; i++) {
            if (l1.get(l1.size() - 1) > l2.get(l2.size() - 1)) l1.add(nums[i]);
            else l2.add(nums[i]);
        }

        int i = 0;
        for (int v : l1) nums[i++] = v;
        for (int v : l2) nums[i++] = v;

        return nums;
    }
}
