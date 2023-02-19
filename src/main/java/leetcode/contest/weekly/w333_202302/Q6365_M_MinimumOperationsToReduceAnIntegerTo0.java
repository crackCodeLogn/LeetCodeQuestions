package leetcode.contest.weekly.w333_202302;

import java.util.TreeSet;

/**
 * @author Vivek
 * @since 2023-02-19
 * WA
 */
public class Q6365_M_MinimumOperationsToReduceAnIntegerTo0 {

    private final int UPPER = (int) Math.pow(10, 6);
    private final TreeSet<Integer> POWER2 = new TreeSet<>();

    public static void main(String[] args) {
        Q6365_M_MinimumOperationsToReduceAnIntegerTo0 q6365MMinimumOperationsToReduceAnIntegerTo0 = new Q6365_M_MinimumOperationsToReduceAnIntegerTo0();
        System.out.println(q6365MMinimumOperationsToReduceAnIntegerTo0.minOperations(39));
        System.out.println(q6365MMinimumOperationsToReduceAnIntegerTo0.minOperations(40));
        System.out.println(q6365MMinimumOperationsToReduceAnIntegerTo0.minOperations(54));
        System.out.println(q6365MMinimumOperationsToReduceAnIntegerTo0.minOperations(53));
        System.out.println(q6365MMinimumOperationsToReduceAnIntegerTo0.minOperations(55));
    }

    private void prep() {
        for (int i = 0; ; i++) {
            int val = (int) Math.pow(2, i);
            if (val > UPPER) break;
            POWER2.add(val);
        }
    }

    public int minOperations(int n) {
        prep();
        int ops = 0;

        if (POWER2.contains(n)) return 1;
        while (true) {
            Integer fl = POWER2.floor(n), cl = POWER2.ceiling(n);
            int diff1 = n - fl, diff2 = cl - n;
            n = Math.min(diff1, diff2);
            ops++;
            if (POWER2.contains(n)) {
                ops++;
                break;
            }
        }
        return ops;
    }
}
