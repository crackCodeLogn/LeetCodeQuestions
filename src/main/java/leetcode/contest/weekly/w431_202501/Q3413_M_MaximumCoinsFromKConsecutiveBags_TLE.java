package leetcode.contest.weekly.w431_202501;

import java.util.TreeMap;

/**
 * @author Vivek
 * @since 2025-01-04
 */
public class Q3413_M_MaximumCoinsFromKConsecutiveBags_TLE {

  private static final int LIMIT = 1_000_000_000;

  public static void main(String[] args) {
    Q3413_M_MaximumCoinsFromKConsecutiveBags_TLE q3413MMaximumCoinsFromKConsecutiveBagsTLE =
        new Q3413_M_MaximumCoinsFromKConsecutiveBags_TLE();
    // System.out.println(q3.maximumCoins(new int[][] {{1, 1000000000, 1000}}, 1000000000)); // tle
    System.out.println(
        q3413MMaximumCoinsFromKConsecutiveBagsTLE.maximumCoins(
            new int[][] {{30, 49, 12}}, 28)); // 240
    System.out.println(
        q3413MMaximumCoinsFromKConsecutiveBagsTLE.maximumCoins(
            new int[][] {
              {8, 10, 1},
              {1, 3, 2},
              {5, 6, 4},
            },
            4)); // 10
    System.out.println(
        q3413MMaximumCoinsFromKConsecutiveBagsTLE.maximumCoins(new int[][] {{1, 10, 3}}, 2)); // 6
  }

  public long maximumCoins(int[][] coins, int k) { // tle
    TreeMap<Integer, Integer> map = new TreeMap<>();
    long max;
    int minIndex = LIMIT + 1, maxIndex = 0;
    for (int[] coin : coins) {
      map.put(coin[0], coin[2]);
      if (!map.containsKey(coin[1] + 1)) map.put(coin[1] + 1, 0);
      minIndex = Math.min(minIndex, coin[0]);
      maxIndex = Math.max(maxIndex, coin[1]);
    }

    long run = 0;
    int i = minIndex, j = minIndex;
    int tval = -1;
    for (; i < k + minIndex; i++) {
      if (map.containsKey(i)) tval = map.get(i);
      run += tval;
    }
    max = run;
    for (; i <= maxIndex; i++, j++) {
      if (map.containsKey(i)) tval = map.get(i);
      run += tval - map.floorEntry(j).getValue();
      max = Math.max(max, run);
    }

    return max;
  }
}
