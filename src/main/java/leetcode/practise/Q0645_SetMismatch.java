package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-01-22
 */
public class Q0645_SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] data = new int[n + 1];
        int[] res = new int[2];

        for (int i = 0; i < n; i++) data[nums[i]]++;
        for (int i = 1; i <= n; i++) {
            if (data[i] == 0) res[1] = i;
            if (data[i] == 2) res[0] = i;
        }
        return res;
    }
}
