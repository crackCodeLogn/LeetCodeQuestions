package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-05-31
 */
public class Q0260_M_SingleNumberIII {

    public static void main(String[] args) {
        Q0260_M_SingleNumberIII q0260MSingleNumberIII = new Q0260_M_SingleNumberIII();
        System.out.println(Arrays.toString(q0260MSingleNumberIII.singleNumber(new int[]{1, 2, 1, 3, 2, 5}))); // 3,5
        System.out.println(Arrays.toString(q0260MSingleNumberIII.singleNumber(new int[]{-1, 0}))); // -1, 0
        System.out.println(Arrays.toString(q0260MSingleNumberIII.singleNumber(new int[]{0, 1}))); // 0,1
        System.out.println(Arrays.toString(q0260MSingleNumberIII.singleNumber(new int[]{2, 1, 2, 3, 4, 1}))); // 3,4
    }

    public int[] singleNumber(int[] nums) {
        if (nums.length == 2) return nums;

        int num = 0, n = nums.length, n1 = 0, n2 = 0;
        for (int i = 0; i < n; i++) num ^= nums[i];

        int v = 1;
        for (int k = 1; k <= 32; v <<= 1, k++) if ((num & v) == v) break;

        for (int i = 0; i < n; i++) {
            if ((nums[i] & v) > 0) n2 ^= nums[i];
            else n1 ^= nums[i];
        }

        return new int[]{n1, n2};
    }
}
