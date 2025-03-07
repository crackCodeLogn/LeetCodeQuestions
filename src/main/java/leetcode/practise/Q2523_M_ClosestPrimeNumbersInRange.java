package leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Vivek
 * @since 2025-03-06
 */
public class Q2523_M_ClosestPrimeNumbersInRange {
  private static final TreeMap<Integer, Integer> primeIndexMap = new TreeMap<>();
  private static final int[] DEAD = {-1, -1};
  private static List<Integer> primes = new ArrayList<>();

  private static List<Integer> classicSieveOfEratosthenes(int n) {
    boolean[] prime = new boolean[n + 1];
    Arrays.fill(prime, true);
    final List<Integer> primes = new ArrayList<>(n);

    for (int p = 2; p * p <= n; p++)
      if (prime[p]) for (int i = p * p; i <= n; i += p) prime[i] = false;

    int k = 0;
    for (int i = 2; i <= n; i++)
      if (prime[i]) {
        primes.add(i);
        primeIndexMap.put(i, k++);
      }
    return primes;
  }

  public static void main(String[] args) {
    Q2523_M_ClosestPrimeNumbersInRange q2523MClosestPrimeNumbersInRange =
        new Q2523_M_ClosestPrimeNumbersInRange();
    System.out.println(Arrays.toString(q2523MClosestPrimeNumbersInRange.closestPrimes(1, 1)));
    System.out.println(Arrays.toString(q2523MClosestPrimeNumbersInRange.closestPrimes(10, 19)));
    System.out.println(Arrays.toString(q2523MClosestPrimeNumbersInRange.closestPrimes(4, 6)));
  }

  public int[] closestPrimes(int left, int right) { // 36 ms, beats 86.40%
    if (primes.isEmpty()) primes = classicSieveOfEratosthenes(1_000_000);

    Map.Entry<Integer, Integer> entry = primeIndexMap.ceilingEntry(left);
    if (entry == null) return DEAD;
    int start = entry.getValue();
    entry = primeIndexMap.floorEntry(right);
    if (entry == null) return DEAD;
    int end = entry.getValue();

    if (primes.get(start) < left || primes.get(end) > right) return DEAD;
    int min = Integer.MAX_VALUE, startVal = -1, endVal = -1;
    for (int i = start; i < end; i++) {
      int diff = primes.get(i + 1) - primes.get(i);
      if (diff < min) {
        min = diff;
        startVal = primes.get(i);
        endVal = primes.get(i + 1);
      }
    }

    return new int[] {startVal, endVal};
  }
}
