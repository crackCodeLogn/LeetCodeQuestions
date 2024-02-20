package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-02-20
 */
public class Q0268_E_MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for (int i = 1; i <= n; i++) xor ^= i;
        for (int i = 0; i < n; i++) xor ^= nums[i];
        return xor;
    }
}
