package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-03-26
 */
public class Q0041_H_FirstMissingPositive {
    public static void main(String[] args) {
        Q0041_H_FirstMissingPositive q0041HFirstMissingPositive = new Q0041_H_FirstMissingPositive();
        System.out.println(q0041HFirstMissingPositive.firstMissingPositive(new int[]{1, 2, 0})); // 3
        System.out.println(q0041HFirstMissingPositive.firstMissingPositive(new int[]{3, 4, -1, 1})); // 2
        System.out.println(q0041HFirstMissingPositive.firstMissingPositive(new int[]{7, 8, 9, 11, 13})); // 1
        System.out.println(q0041HFirstMissingPositive.firstMissingPositive(new int[]{1, 1})); // 2
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) if (nums[i] <= 0 || nums[i] > n) nums[i] = n + 1;
        for (int i = 0; i < n; i++)
            if (Math.abs(nums[i]) != n + 1 && nums[Math.abs(nums[i]) - 1] > 0) nums[Math.abs(nums[i]) - 1] *= -1;
        for (int i = 0; i < n; i++) if (nums[i] > 0) return i + 1;
        return n + 1;
    }

}
