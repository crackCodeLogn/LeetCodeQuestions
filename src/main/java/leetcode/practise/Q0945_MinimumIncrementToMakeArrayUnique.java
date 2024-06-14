package leetcode.practise;

import java.util.Arrays;

public class Q0945_MinimumIncrementToMakeArrayUnique {

    public static void main(String[] args) {
        Q0945_MinimumIncrementToMakeArrayUnique q0945MinimumIncrementToMakeArrayUnique = new Q0945_MinimumIncrementToMakeArrayUnique();
        System.out.println(q0945MinimumIncrementToMakeArrayUnique.minIncrementForUnique(new int[]{1, 2, 2})); // 1
        System.out.println(q0945MinimumIncrementToMakeArrayUnique.minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7})); // 6
    }

    public int minIncrementForUnique(int[] nums) {
        int cnt = 0;
        int minAvailable = 0;

        Arrays.sort(nums);
        for (int num : nums) {
            cnt += Math.max(minAvailable - num, 0);
            minAvailable = Math.max(minAvailable, num) + 1;
        }

        return cnt;
    }
}
