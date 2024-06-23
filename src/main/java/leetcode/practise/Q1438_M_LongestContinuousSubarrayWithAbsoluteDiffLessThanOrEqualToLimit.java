package leetcode.practise;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Vivek
 * @since 2024-06-23
 */
public class Q1438_M_LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    public static void main(String[] args) {
        Q1438_M_LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit q1438MLongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit = new Q1438_M_LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit();
        System.out.println(q1438MLongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit.longestSubarray(new int[]{8, 2, 4, 7}, 4)); // 2
        System.out.println(q1438MLongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit.longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5)); // 4
        System.out.println(q1438MLongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit.longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0)); // 3
    }

    public int longestSubarray(int[] nums, int limit) {
        int ans = 1;
        Deque<Integer> minQ = new LinkedList<>();
        Deque<Integer> maxQ = new LinkedList<>();

        for (int l = 0, r = 0; r < nums.length; ++r) {
            while (!minQ.isEmpty() && minQ.getLast() > nums[r])
                minQ.removeLast();
            minQ.addLast(nums[r]);
            while (!maxQ.isEmpty() && maxQ.getLast() < nums[r])
                maxQ.removeLast();
            maxQ.addLast(nums[r]);
            while (maxQ.getFirst() - minQ.getFirst() > limit) {
                if (minQ.getFirst() == nums[l])
                    minQ.removeFirst();
                if (maxQ.getFirst() == nums[l])
                    maxQ.removeFirst();
                ++l;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
