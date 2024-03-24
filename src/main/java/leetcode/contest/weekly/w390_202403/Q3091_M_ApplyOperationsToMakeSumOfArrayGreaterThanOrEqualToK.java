package leetcode.contest.weekly.w390_202403;

/**
 * @author Vivek
 * @since 2024-03-24
 */
public class Q3091_M_ApplyOperationsToMakeSumOfArrayGreaterThanOrEqualToK {

    public static void main(String[] args) {
        Q3091_M_ApplyOperationsToMakeSumOfArrayGreaterThanOrEqualToK q3091MApplyOperationsToMakeSumOfArrayGreaterThanOrEqualToK2 = new Q3091_M_ApplyOperationsToMakeSumOfArrayGreaterThanOrEqualToK();
        System.out.println(q3091MApplyOperationsToMakeSumOfArrayGreaterThanOrEqualToK2.minOperations(11)); // 5
        System.out.println(q3091MApplyOperationsToMakeSumOfArrayGreaterThanOrEqualToK2.minOperations(5)); // ?
        System.out.println(q3091MApplyOperationsToMakeSumOfArrayGreaterThanOrEqualToK2.minOperations(4)); // ?
        System.out.println(q3091MApplyOperationsToMakeSumOfArrayGreaterThanOrEqualToK2.minOperations(3)); // ?
        System.out.println(q3091MApplyOperationsToMakeSumOfArrayGreaterThanOrEqualToK2.minOperations(1)); // 0
    }

    public int minOperations(int k) {
        if (k <= 2) return k - 1;
        int cnt = Integer.MAX_VALUE;
        for (int i = 1; ; i++) {
            int base = i + 1;
            int local = (int) Math.ceil((double) k / base) - 2 + base;
            cnt = Math.min(cnt, local);
            if (i > cnt) break;
        }
        return cnt;
    }
}
