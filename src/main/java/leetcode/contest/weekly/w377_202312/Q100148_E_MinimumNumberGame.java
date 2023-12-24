package leetcode.contest.weekly.w377_202312;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2023-12-24
 */
public class Q100148_E_MinimumNumberGame {

    public static void main(String[] args) {
        Q100148_E_MinimumNumberGame q100148EMinimumNumberGame = new Q100148_E_MinimumNumberGame();
        printArray(q100148EMinimumNumberGame.numberGame(new int[]{5, 4, 2, 3}));
    }

    private static void printArray(int[] data) {
        for (int t : data) System.out.print(t + " ");
        System.out.println();
    }

    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
        return nums;
    }

    private void swap(int[] data, int i, int j) {
        int buff = data[i];
        data[i] = data[j];
        data[j] = buff;
    }
}
