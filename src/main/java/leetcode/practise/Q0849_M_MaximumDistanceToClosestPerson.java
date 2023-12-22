package leetcode.practise;

import java.util.TreeSet;

/**
 * @author Vivek
 * @since 2023-12-22
 */
public class Q0849_M_MaximumDistanceToClosestPerson {

    public static void main(String[] args) {
        Q0849_M_MaximumDistanceToClosestPerson q0849MMaximumDistanceToClosestPerson = new Q0849_M_MaximumDistanceToClosestPerson();
        System.out.println(q0849MMaximumDistanceToClosestPerson.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1})); // 2
        System.out.println(q0849MMaximumDistanceToClosestPerson.maxDistToClosest(new int[]{1, 0, 0, 0})); // 3
        System.out.println(q0849MMaximumDistanceToClosestPerson.maxDistToClosest(new int[]{0, 1})); // 1
    }

    public int maxDistToClosest(int[] seats) {
        TreeSet<Integer> data = new TreeSet<>();
        int n = seats.length;
        for (int i = 0; i < n; i++) if (seats[i] == 1) data.add(i);

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                Integer floor = data.floor(i), ceil = data.ceiling(i);
                if (floor == null) floor = 0;
                if (ceil == null) ceil = n - 1;
                max = Math.max(max,
                        Math.min(getVal(i - floor), getVal(ceil - i)));
            }
        }
        return max;
    }

    private int getVal(int v) {
        return v == 0 ? Integer.MAX_VALUE : v;
    }
}
