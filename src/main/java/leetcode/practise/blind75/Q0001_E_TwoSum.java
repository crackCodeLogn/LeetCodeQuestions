package leetcode.practise.blind75;

import java.util.*;

/**
 * @author Vivek
 * @since 2023-12-22
 */
public class Q0001_E_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{i, map.get(target - nums[i])};
            map.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        int first = 0, second = 0;
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Queue<Integer> q = map.get(nums[i]);
            if (q == null) q = new LinkedList<>();
            q.offer(i);
            map.put(nums[i], q);
        }
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < nums.length; i++) {
            while (j > i && nums[j] > target - nums[i]) j--;
            if (nums[i] + nums[j] == target) return new int[]{map.get(nums[i]).poll(), map.get(nums[j]).poll()};
        }
        return null;
    }
}
