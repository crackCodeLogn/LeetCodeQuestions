package leetcode.contest.weekly.w340_202304;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vivek
 * @since 2023-04-09
 */
public class Q6360_M_SumOfDistances {

    public static void main(String[] args) {
        Q6360_M_SumOfDistances q6360MSumOfDistances = new Q6360_M_SumOfDistances();

        Arrays.stream(q6360MSumOfDistances.distance(new int[]{
                0, 1, 2, 3, 1
        })).forEach(System.out::println);

        /*Arrays.stream(q2.distance(new int[]{
                2, 0, 2, 2, 6, 5, 2
        })).forEach(System.out::println);
        Arrays.stream(q2.distance(new int[]{
                0, 5, 3, 1, 2, 8, 6, 6, 6
        })).forEach(System.out::println);*/
        /*Arrays.stream(q2.distance(new int[]{
                1, 3, 1, 1, 2
        })).forEach(System.out::println);
        Arrays.stream(q2.distance(new int[]{
                0, 5, 3
        })).forEach(System.out::println);*/
    }

    public long[] distance(int[] nums) {
        long[] data = new long[nums.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.get(nums[i]);
            if (list == null) list = new ArrayList<>();
            list.add(i);
            map.put(nums[i], list);
        }

        map.forEach((k, v) -> {
            if (v.size() > 1) {
                long totalSum = 0, preSum = 0;
                for (int i = 0; i < v.size(); i++) totalSum += v.get(i);

                for (int i = 0; i < v.size(); i++) {
                    int index = v.get(i);
                    long val = totalSum - index - (v.size() - i - 1L) * index - preSum + (long) index * i - preSum;
                    preSum += v.get(i);
                    data[index] = val;
                }
            } else {
                data[v.get(0)] = 0;
            }
        });
        return data;
    }
}
