package leetcode.contest.weekly.w342_202304;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vivek
 * @since 2023-04-24
 */
public class Q2652_E_SumMultiples {

    public int sumOfMultiples(int n) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 3; i <= n; i += 3) {
            sum += i;
            set.add(i);
        }
        for (int i = 5; i <= n; i += 5) {
            if (!set.contains(i)) {
                sum += i;
                set.add(i);
            }
        }
        for (int i = 7; i <= n; i += 7) {
            if (!set.contains(i)) {
                sum += i;
                set.add(i);
            }
        }
        return sum;
    }
}
