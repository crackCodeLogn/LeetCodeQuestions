package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-03-31
 */
public class Q2444_H_CountSubarraysWithFixedBounds {

    public static void main(String[] args) {
        Q2444_H_CountSubarraysWithFixedBounds q2444HCountSubarraysWithFixedBounds = new Q2444_H_CountSubarraysWithFixedBounds();
        System.out.println(q2444HCountSubarraysWithFixedBounds.countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5)); // 2
        System.out.println(q2444HCountSubarraysWithFixedBounds.countSubarrays(new int[]{1, 1, 1, 1}, 1, 1)); // 10
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int j = -1;
        int prevMinKIndex = -1;
        int prevMaxKIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) j = i;
            if (nums[i] == minK) prevMinKIndex = i;
            if (nums[i] == maxK) prevMaxKIndex = i;
            res += Math.max(0, Math.min(prevMinKIndex, prevMaxKIndex) - j);
        }

        return res;
    }
}
