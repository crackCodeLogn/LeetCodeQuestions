package leetcode.contest.weekly.w393_202404;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q3115_M_MaximumPrimeDifferences {
    private static final Set<Integer> primes = new HashSet<>();

    private static int[] sieveEratosthenes(int n) { // faster
        int[] minPrimeFactors = new int[n + 1];
        for (int i = 2; i <= n; ++i) minPrimeFactors[i] = i;
        for (int i = 2; i * i < n; ++i)
            if (minPrimeFactors[i] == i)
                for (int j = i * i; j < n; j += i) minPrimeFactors[j] = Math.min(minPrimeFactors[j], i);
        return minPrimeFactors;
    }

    public int maximumPrimeDifference(int[] nums) {
        if (primes.isEmpty()) Arrays.stream(sieveEratosthenes(120)).forEach(primes::add);

        int lb = 0, n = nums.length, ub = n - 1;
        while (!primes.contains(nums[lb])) lb++;
        while (!primes.contains(nums[ub])) ub--;
        return ub - lb;
    }

    public static void main(String[] args) {
        Q3115_M_MaximumPrimeDifferences q3115MMaximumPrimeDifferences = new Q3115_M_MaximumPrimeDifferences();
        System.out.println(q3115MMaximumPrimeDifferences.maximumPrimeDifference(new int[]{4, 2, 9, 5, 3}));
        System.out.println(q3115MMaximumPrimeDifferences.maximumPrimeDifference(new int[]{4, 8, 2, 8}));
        System.out.println(q3115MMaximumPrimeDifferences.maximumPrimeDifference(new int[]{2, 2})); // 1
    }
}
