package leetcode.practise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Q2597_M_TheNumberOfBeautifulSubsets {

    public static void main(String[] args) {
        Q2597_M_TheNumberOfBeautifulSubsets q2597MTheNumberOfBeautifulSubsets = new Q2597_M_TheNumberOfBeautifulSubsets();
        System.out.println(q2597MTheNumberOfBeautifulSubsets.beautifulSubsets(new int[]{2, 4, 6}, 2)); // 4
        System.out.println(q2597MTheNumberOfBeautifulSubsets.beautifulSubsets(new int[]{1}, 1)); // 1
    }

    public int beautifulSubsets(int[] nums, int k) {
        int kMaxNum = 1000;
        int[] count = new int[kMaxNum + 1];
        Map<Integer, Set<Integer>> modToSubset = new HashMap<>();

        for (int num : nums) {
            count[num]++;
            modToSubset.putIfAbsent(num % k, new TreeSet<>());
            modToSubset.get(num % k).add(num);
        }

        int prevNum = -k;
        int skip = 0;
        int pick = 0;

        for (Set<Integer> subset : modToSubset.values())
            for (int num : subset) {
                int nonEmptyCount = (int) Math.pow(2, count[num]) - 1;
                int cacheSkip = skip;
                skip += pick;
                pick = nonEmptyCount * (1 + cacheSkip + (num - prevNum == k ? 0 : pick));
                prevNum = num;
            }

        return skip + pick;
    }
}
