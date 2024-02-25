package leetcode.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vivek
 * @since 2024-02-25
 */
public class Q2709_H_GreatestCommonDivisorTraversal {
    private static int getMaxFromArray(int[] data) {
        int max = Integer.MIN_VALUE;
        for (int i = -1; ++i < data.length; ) if (data[i] > max) max = data[i];
        return max;
    }

    public static void main(String[] args) {
        Q2709_H_GreatestCommonDivisorTraversal q2709HGreatestCommonDivisorTraversal = new Q2709_H_GreatestCommonDivisorTraversal();
        System.out.println(q2709HGreatestCommonDivisorTraversal.canTraverseAllPairs(new int[]{2, 3, 6})); // true
        System.out.println(q2709HGreatestCommonDivisorTraversal.canTraverseAllPairs(new int[]{3, 9, 5})); // false
        System.out.println(q2709HGreatestCommonDivisorTraversal.canTraverseAllPairs(new int[]{4, 3, 12, 8})); //true
    }

    // Gets the minimum prime factor of i, where 1 < i <= n.
    private int[] sieveEratosthenes(int n) {
        int[] minPrimeFactors = new int[n + 1];
        for (int i = 2; i <= n; ++i)
            minPrimeFactors[i] = i;
        for (int i = 2; i * i < n; ++i)
            if (minPrimeFactors[i] == i)
                for (int j = i * i; j < n; j += i)
                    minPrimeFactors[j] = Math.min(minPrimeFactors[j], i);
        return minPrimeFactors;
    }

    private List<Integer> getPrimeFactors(int num, int[] minPrimeFactors) {
        List<Integer> primeFactors = new ArrayList<>();
        while (num > 1) {
            final int divisor = minPrimeFactors[num];
            primeFactors.add(divisor);
            while (num % divisor == 0)
                num /= divisor;
        }
        return primeFactors;
    }

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        int maxNum = getMaxFromArray(nums);
        int[] primes = sieveEratosthenes(maxNum + 1);
        Map<Integer, Integer> primeToFirstIndex = new HashMap<>();
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; ++i)
            for (int primeFactor : getPrimeFactors(nums[i], primes))
                // `primeFactor` already appeared in the previous indices.
                if (primeToFirstIndex.containsKey(primeFactor))
                    uf.unionBySize(primeToFirstIndex.get(primeFactor), i);
                else
                    primeToFirstIndex.put(primeFactor, i);

        for (int i = 0; i < n; i++) if (uf.getSize(i) == n) return true;
        return false;
    }

    private static class UnionFind {

        private final int[] id;
        private final int[] sz;

        public UnionFind(int n) {
            id = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) id[i] = i;
            for (int i = 0; i < n; i++) sz[i] = 1;
        }

        public void unionBySize(int u, int v) {
            final int i = find(u);
            final int j = find(v);
            if (i == j) return;
            if (sz[i] < sz[j]) {
                sz[j] += sz[i];
                id[i] = j;
            } else {
                sz[i] += sz[j];
                id[j] = i;
            }
        }

        public int getSize(int i) {
            return sz[i];
        }

        private int find(int u) {
            return id[u] == u ? u : (id[u] = find(id[u]));
        }
    }
}
