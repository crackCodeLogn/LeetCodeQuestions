package leetcode.contest.weekly.w398_202405;

/**
 * @author Vivek
 * @since 2024-05-19
 */
public class Q3151_E_SpecialArrayI {

    public static void main(String[] args) {
        Q3151_E_SpecialArrayI q3151ESpecialArrayI = new Q3151_E_SpecialArrayI();
        System.out.println(q3151ESpecialArrayI.isArraySpecial(new int[]{2}));
        System.out.println(q3151ESpecialArrayI.isArraySpecial(new int[]{2, 1, 4}));
        System.out.println(q3151ESpecialArrayI.isArraySpecial(new int[]{4, 3, 1, 6}));
    }

    public boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) if ((((nums[i] ^ nums[i - 1]) & 1) == 0)) return false;
        return true;
    }

    public boolean isArraySpecial2(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;

        for (int i = 1; i < n; i++) {
            if (!((isOdd(nums[i]) && !isOdd(nums[i - 1])) || (!isOdd(nums[i]) && isOdd(nums[i - 1])))) return false;
        }
        return true;
    }

    private boolean isOdd(int n) {
        return (n & 1) == 1;
    }
}
