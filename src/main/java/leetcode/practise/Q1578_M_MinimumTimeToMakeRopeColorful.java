package leetcode.practise;

import java.util.PriorityQueue;

/**
 * @author Vivek
 * @since 2023-12-27
 */
public class Q1578_M_MinimumTimeToMakeRopeColorful {

    public static void main(String[] args) {
        Q1578_M_MinimumTimeToMakeRopeColorful q1578MMinimumTimeToMakeRopeColorful = new Q1578_M_MinimumTimeToMakeRopeColorful();
        System.out.println(q1578MMinimumTimeToMakeRopeColorful.minCost("abaac", new int[]{1, 2, 3, 4, 5}));
        System.out.println(q1578MMinimumTimeToMakeRopeColorful.minCost("abc", new int[]{1, 2, 3}));
        System.out.println(q1578MMinimumTimeToMakeRopeColorful.minCost("aabaa", new int[]{1, 2, 3, 4, 1}));
        System.out.println(q1578MMinimumTimeToMakeRopeColorful.minCost("bbbaaa", new int[]{4, 9, 3, 8, 8, 9})); //23
    }

    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        char last = colors.charAt(0);
        int length = 1, cost = 0;
        int runningCost = neededTime[0], maxRunningCost = neededTime[0];

        for (int i = 1; i < n; i++) {
            char ch = colors.charAt(i);
            if (ch == last) {
                length++;
                runningCost += neededTime[i];
                maxRunningCost = Math.max(maxRunningCost, neededTime[i]);

            } else { //reached a diff color
                if (length > 1) cost += runningCost - maxRunningCost;
                length = 1;
                last = ch;
                runningCost = neededTime[i];
                maxRunningCost = neededTime[i];
            }
        }
        if (length > 1) cost += runningCost - maxRunningCost;
        return cost;
    }

    public int minCost2(String colors, int[] neededTime) {
        int n = colors.length();
        char last = colors.charAt(0);
        int length = 1, cost = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(neededTime[0]);

        for (int i = 1; i < n; i++) {
            char ch = colors.charAt(i);
            if (ch == last) {
                length++;
                queue.offer(neededTime[i]);

            } else { //reached a diff color
                if (length > 1) {
                    while (queue.size() != 1) cost += queue.poll();
                }
                length = 1;
                last = ch;
                queue.clear();
                queue.offer(neededTime[i]);
            }
        }
        if (length > 1) {
            while (queue.size() != 1) cost += queue.poll();
        }
        return cost;
    }

}
