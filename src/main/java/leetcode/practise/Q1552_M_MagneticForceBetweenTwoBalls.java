package leetcode.practise;

import java.util.Arrays;

public class Q1552_M_MagneticForceBetweenTwoBalls {

    public static void main(String[] args) {
        Q1552_M_MagneticForceBetweenTwoBalls q1552MMagneticForceBetweenTwoBalls = new Q1552_M_MagneticForceBetweenTwoBalls();
        System.out.println(q1552MMagneticForceBetweenTwoBalls.maxDistance(new int[]{1, 2, 3, 4, 7}, 3)); // 3
        System.out.println(q1552MMagneticForceBetweenTwoBalls.maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2)); // 999999999
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lb = 1;
        int ub = position[position.length - 1] - position[0];
        while (lb < ub) {
            final int mid = ub - (ub - lb) / 2;
            if (numBalls(position, mid) >= m) lb = mid;
            else ub = mid - 1;
        }
        return lb;
    }

    private int numBalls(int[] position, int force) {
        int balls = 0;
        int prevPosition = -force;
        for (int pos : position)
            if (pos - prevPosition >= force) {
                balls++;
                prevPosition = pos;
            }
        return balls;
    }
}
