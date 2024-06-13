package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-06-13
 */
public class Q2037_E_MinimumNumberOfMovesToSeatEveryone {

    public static void main(String[] args) {
        Q2037_E_MinimumNumberOfMovesToSeatEveryone q2037EMinimumNumberOfMovesToSeatEveryone = new Q2037_E_MinimumNumberOfMovesToSeatEveryone();
        System.out.println(q2037EMinimumNumberOfMovesToSeatEveryone.minMovesToSeat(new int[]{3, 1, 5}, new int[]{2, 7, 4}));
        System.out.println(q2037EMinimumNumberOfMovesToSeatEveryone.minMovesToSeat(new int[]{4, 1, 5, 9}, new int[]{1, 3, 2, 6}));
        System.out.println(q2037EMinimumNumberOfMovesToSeatEveryone.minMovesToSeat(new int[]{2, 2, 6, 6}, new int[]{1, 3, 2, 6}));
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int moves = 0;
        for (int i = 0; i < seats.length; i++) moves += Math.abs(seats[i] - students[i]);
        return moves;
    }
}
