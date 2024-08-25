package leetcode.contest.weekly.w412_202408;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-08-24
 */
public class Q3264_E_FinalArrayStateAfterKMultiplicationOperationsI {

    public static void main(String[] args) {
        Q3264_E_FinalArrayStateAfterKMultiplicationOperationsI q3264EFinalArrayStateAfterKMultiplicationOperationsI = new Q3264_E_FinalArrayStateAfterKMultiplicationOperationsI();
        System.out.println(Arrays.toString(q3264EFinalArrayStateAfterKMultiplicationOperationsI.getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2)));
        System.out.println(Arrays.toString(q3264EFinalArrayStateAfterKMultiplicationOperationsI.getFinalState(new int[]{1, 2}, 3, 4)));
        System.out.println(Arrays.toString(q3264EFinalArrayStateAfterKMultiplicationOperationsI.getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2))); //8 4 6 5 6
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while (k-- > 0) {
            int loc = 0, min = nums[0];
            for (int i = 1; i < nums.length; i++)
                if (nums[i] < min) {
                    min = nums[i];
                    loc = i;
                }
            nums[loc] *= multiplier;
        }
        return nums;
    }
}
