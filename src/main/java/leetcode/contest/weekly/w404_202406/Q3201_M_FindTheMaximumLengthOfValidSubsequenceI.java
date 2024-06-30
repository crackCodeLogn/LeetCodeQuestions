package leetcode.contest.weekly.w404_202406;

/**
 * @author Vivek
 * @since 2024-06-30
 */
public class Q3201_M_FindTheMaximumLengthOfValidSubsequenceI {

    public static void main(String[] args) {
        Q3201_M_FindTheMaximumLengthOfValidSubsequenceI q3201MFindTheMaximumLengthOfValidSubsequenceI = new Q3201_M_FindTheMaximumLengthOfValidSubsequenceI();
        System.out.println(q3201MFindTheMaximumLengthOfValidSubsequenceI.maximumLength(new int[]{1, 2, 3, 4})); // 4
        System.out.println(q3201MFindTheMaximumLengthOfValidSubsequenceI.maximumLength(new int[]{1, 2, 1, 1, 2, 1, 2})); // 6
        System.out.println(q3201MFindTheMaximumLengthOfValidSubsequenceI.maximumLength(new int[]{1, 3})); // 2
        System.out.println(q3201MFindTheMaximumLengthOfValidSubsequenceI.maximumLength(new int[]{2, 39, 23})); // 2
    }

    public int maximumLength(int[] nums) {
        if (nums.length == 2) return 2;

        int len = 0, n = nums.length;
        boolean[] data = new boolean[n];
        for (int i = 0; i < n; i++) data[i] = isEven(nums[i]);

        int l1 = 1, l2 = 1, l3 = 1;
        // variant 1 - true true
        int i = 0;
        while (i < n && !data[i++]) ;
        for (; i < n; i++) if (data[i]) l1++;
        len = l1;

        // variant 2 = f f
        i = 0;
        while (i < n && data[i++]) ;
        for (; i < n; i++) if (!data[i]) l2++;
        len = Math.max(len, l2);

        // var 3 =tf, ft
        boolean flag = data[0];
        for (i = 1; i < n; i++)
            if (data[i] == !flag) {
                l3++;
                flag = !flag;
            }
        return Math.max(len, l3);
    }

    private boolean isEven(int n) {
        return (n & 1) == 0;
    }
}
