package leetcode.contest.weekly.w341_202304;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Vivek
 * @since 2023-04-16
 */
public class Q6350_E_FindTheMaxiumDivisibilityScore {

    public int maxDivScore(int[] nums, int[] divisors) {
        Set<Integer> divs = new HashSet<>();
        Arrays.stream(divisors).forEach(divs::add);
        int divi = -1, cnti = -1;
        for (Integer div : divs) {
            int cnt = 0;
            for (int num : nums) if (num % div == 0) cnt++;
            if (cnt > cnti) {
                divi = div;
                cnti = cnt;
            } else if (cnt == cnti) {
                divi = Math.min(divi, div);
            }
        }
        return divi;
    }
}
