package leetcode.contest.weekly.w407_202407;

/**
 * @author Vivek
 * @since 2024-07-21
 */
public class Q3226_E_NumberOfBitChangesToMakeTwoIntegersEquals {
    public static void main(String[] args) {
        Q3226_E_NumberOfBitChangesToMakeTwoIntegersEquals q3226ENumberOfBitChangesToMakeTwoIntegersEquals = new Q3226_E_NumberOfBitChangesToMakeTwoIntegersEquals();
        System.out.println(q3226ENumberOfBitChangesToMakeTwoIntegersEquals.minChanges(13, 4));
        System.out.println(q3226ENumberOfBitChangesToMakeTwoIntegersEquals.minChanges(14, 13));
        System.out.println(q3226ENumberOfBitChangesToMakeTwoIntegersEquals.minChanges(54, 4));
        System.out.println(q3226ENumberOfBitChangesToMakeTwoIntegersEquals.minChanges(11, 56));
    }

    public int minChanges(int n, int k) {
        if (n == k) return 0;
        int cnt = 0;
        while (n > 0 && k > 0) {
            boolean nLast = (n & 1) == 1;
            boolean kLast = (k & 1) == 1;
            if (!nLast && kLast) return -1;
            else if (nLast && !kLast) cnt++;
            n >>= 1;
            k >>= 1;
        }
        if (k > 0) return -1;
        while (n > 0) {
            if ((n & 1) == 1) cnt++;
            n >>= 1;
        }
        return cnt;
    }
}
