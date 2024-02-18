package leetcode.contest.weekly.w385_202402;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Vivek
 * @since 2024-02-18
 * // got accepted at 2300:40 :(
 */
public class Q100217_M_MostFrequentPrime {
    private static final Map<String, Integer> counter = new HashMap<>();
    private static Set<String> primes = new HashSet<>();
    private static final Set<String> exclusion = new HashSet<>();

    private static Set<String> classicSieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        final List<Integer> primes = new ArrayList<>(); //faster than insertion in LinkedList

        for (int p = 2; p * p <= n; p++)
            if (prime[p]) for (int i = p * p; i <= n; i += p) prime[i] = false;

        // Print all prime numbers
        for (int i = 2; i <= n; i++) if (prime[i]) primes.add(i);
        return primes.stream().map(String::valueOf).collect(Collectors.toSet());
    }

    private static <K> void augmentCount(Map<K, Integer> mapper, K key) {
        Integer val = mapper.get(key);
        if (val == null) val = 1;
        else val++;
        mapper.put(key, val);
    }

    public static void main(String[] args) {
        Q100217_M_MostFrequentPrime q100217MMostFrequentPrime = new Q100217_M_MostFrequentPrime();
        System.out.println(q100217MMostFrequentPrime.mostFrequentPrime(new int[][]{
                {1, 1},
                {9, 9},
                {1, 1},
        }));
        System.out.println(q100217MMostFrequentPrime.mostFrequentPrime(new int[][]{
                {7},
        }));
        System.out.println(q100217MMostFrequentPrime.mostFrequentPrime(new int[][]{
                {9, 7, 8},
                {4, 6, 5},
                {2, 8, 6},
        }));
    }

    public int mostFrequentPrime(int[][] mat) {
        counter.clear();
        if (primes.isEmpty()) {
            primes = classicSieveOfEratosthenes((int) 1e6);
            for (int i = 0; i <= 10; i++) exclusion.add(String.valueOf(i));
        }
        int n = mat.length, m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                StringBuilder data = new StringBuilder();
                for (int a = i; a < n; a++) { // n -> s
                    data.append(mat[a][j]);
                    augmentCount(counter, data.toString());
                }

                data = new StringBuilder();
                for (int a = i; a >= 0; a--) { // s -> n
                    data.append(mat[a][j]);
                    augmentCount(counter, data.toString());
                }

                data = new StringBuilder();
                for (int a = j; a < m; a++) { // w -> e
                    data.append(mat[i][a]);
                    augmentCount(counter, data.toString());
                }

                data = new StringBuilder();
                for (int a = j; a >= 0; a--) { // e -> w
                    data.append(mat[i][a]);
                    augmentCount(counter, data.toString());
                }

                data = new StringBuilder();
                for (int a = i, b = j; a < n && b < m; a++, b++) { // nw -> se
                    data.append(mat[a][b]);
                    augmentCount(counter, data.toString());
                }

                data = new StringBuilder();
                for (int a = i, b = j; a >= 0 && b >= 0; a--, b--) { // se -> nw
                    data.append(mat[a][b]);
                    augmentCount(counter, data.toString());
                }

                data = new StringBuilder();
                for (int a = i, b = j; a < n && b >= 0; a++, b--) { // ne -> sw
                    data.append(mat[a][b]);
                    augmentCount(counter, data.toString());
                }

                data = new StringBuilder();
                for (int a = i, b = j; a >= 0 && b < m; a--, b++) { // sw -> ne
                    data.append(mat[a][b]);
                    augmentCount(counter, data.toString());
                }
            }
        }

        // System.out.println(counter);
        int max = -1;
        for (String key : counter.keySet()) {
            if (!exclusion.contains(key) && primes.contains(key)) {
                max = Math.max(max, counter.get(key));
            }
        }
        if (max == -1) return -1;
        int m1 = -1;
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            if (!exclusion.contains(entry.getKey()) && primes.contains(entry.getKey()) && entry.getValue() == max) {
                m1 = Math.max(m1, Integer.parseInt(entry.getKey()));
            }
        }
        return m1;
    }
}
