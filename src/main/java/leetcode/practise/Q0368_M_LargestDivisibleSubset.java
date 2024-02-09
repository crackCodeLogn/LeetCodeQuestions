package leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-02-10
 */
public class Q0368_M_LargestDivisibleSubset {
    public static void main(String[] args) {
        Q0368_M_LargestDivisibleSubset q0368MLargestDivisibleSubset = new Q0368_M_LargestDivisibleSubset();
        System.out.println(q0368MLargestDivisibleSubset.largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(q0368MLargestDivisibleSubset.largestDivisibleSubset(new int[]{1, 2, 4, 8}));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int[] sizeEndsAt = new int[n];
        int[] prevIndex = new int[n];
        int maxSize = 0;
        int index = -1;

        Arrays.fill(sizeEndsAt, 1);
        Arrays.fill(prevIndex, -1);
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--)
                if (nums[i] % nums[j] == 0 && sizeEndsAt[i] < sizeEndsAt[j] + 1) {
                    sizeEndsAt[i] = sizeEndsAt[j] + 1;
                    prevIndex[i] = j;
                }
            if (maxSize < sizeEndsAt[i]) {
                maxSize = sizeEndsAt[i];
                index = i;
            }
        }

        while (index != -1) {
            ans.add(nums[index]);
            index = prevIndex[index];
        }

        return ans;
    }
}
