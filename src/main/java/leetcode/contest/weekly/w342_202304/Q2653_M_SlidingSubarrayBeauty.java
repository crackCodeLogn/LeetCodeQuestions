package leetcode.contest.weekly.w342_202304;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vivek
 * @since 2023-04-23
 */
public class Q2653_M_SlidingSubarrayBeauty {

    public static void main(String[] args) {
        Q2653_M_SlidingSubarrayBeauty q2563MSlidingSubarrayBeauty = new Q2653_M_SlidingSubarrayBeauty();
        Arrays.stream(q2563MSlidingSubarrayBeauty.getSubarrayBeauty(new int[]{
                1, -1, -3, -2, 3
        }, 3, 2)).forEach(System.out::println);

        System.out.println("------------");
        Arrays.stream(q2563MSlidingSubarrayBeauty.getSubarrayBeauty(new int[]{
                -1, -2, -3, -4, -5
        }, 2, 2)).forEach(System.out::println);

        System.out.println("------------");
        Arrays.stream(q2563MSlidingSubarrayBeauty.getSubarrayBeauty(new int[]{
                -3, 1, 2, -3, 0, -3
        }, 2, 1)).forEach(System.out::println);
    }

    private void addSorted(List<Integer> slots, int element) {
        int low = 0, high = slots.size() - 1, location = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (element == slots.get(mid)) {
                location = mid;
                break;
            } else if (element > slots.get(mid)) low = mid + 1;
            else high = mid - 1;
        }
        if (high < 0) location = 0;
        else if (low >= slots.size()) location = slots.size();
        location = location == -1 ? low : location;
        slots.add(location, element);
    }

    private int compute(int val) {
        return Math.min(val, 0);
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] data = new int[n - k + 1];
        List<Integer> slots = new ArrayList<>(k);
        int i = 0, j = 0;
        for (; i < k; i++) addSorted(slots, nums[i]);
        data[j++] = compute(slots.get(x - 1));
        for (; i < n; i++) {
            Integer rem = nums[i - k];
            slots.remove(rem);
            addSorted(slots, nums[i]);
            data[j++] = compute(slots.get(x - 1));
        }
        return data;
    }
}
