package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-03-02
 */
public class Q0977_E_SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) { // 1ms
        int n = nums.length;
        int[] data = new int[n];
        int low = 0, high = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            nums[high] = Math.abs(nums[high]);
            nums[low] = Math.abs(nums[low]);
            if (nums[high] >= nums[low]) {
                data[i] = nums[high] * nums[high];
                high--;
            } else {
                data[i] = nums[low] * nums[low];
                low++;
            }
        }
        return data;
    }

    public int[] sortedSquares2(int[] nums) { // 7ms
        for (int i = 0; i < nums.length; i++) nums[i] *= nums[i];
        Arrays.sort(nums);
        return nums;
    }
}
