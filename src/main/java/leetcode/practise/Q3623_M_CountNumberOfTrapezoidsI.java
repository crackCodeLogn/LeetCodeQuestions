package leetcode.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vivek
 * @since 2025-12-01
 */
public class Q3623_M_CountNumberOfTrapezoidsI {
  private static final int MOD = (int) (Math.pow(10, 9) + 7);
  private static final Map<Long, Long> nc2Map = new HashMap<>();

  public static void main(String[] args) {
    Q3623_M_CountNumberOfTrapezoidsI q3623MCountNumberOfTrapezoidsI =
        new Q3623_M_CountNumberOfTrapezoidsI();
    System.out.println(
        q3623MCountNumberOfTrapezoidsI.countTrapezoids(
            new int[][] {
              {1, 0},
              {2, 0},
              {3, 0},
              {2, 2},
              {3, 2},
            }));
    System.out.println(
        q3623MCountNumberOfTrapezoidsI.countTrapezoids(
            new int[][] {
              {0, 0},
              {1, 0},
              {0, 1},
              {2, 1}
            }));
  }

  public int countTrapezoids(int[][] points) { // 48ms, beats 43.37%
    long res = 0;
    Map<Integer, Long> map = new HashMap<>();
    for (int[] p : points) {
      int y = p[1];
      if (!map.containsKey(y)) map.put(y, 0L);
      map.put(y, map.get(y) + 1);
    }
    List<Long> uniqueRows = new ArrayList<>(map.size());
    long sum = 0;
    long sum2 = 0;
    for (Long key : map.values()) {
      if (!nc2Map.containsKey(key)) nc2Map.put(key, nc2(key));
      long val = nc2Map.get(key);
      uniqueRows.add(val);
      sum += val;
      sum2 += val * val;
    }
    /*for (int i = 0; i < uniqueRows.size(); i++) {
      for (int j = i + 1; j < uniqueRows.size(); j++) {
        res = res + (uniqueRows.get(i) * uniqueRows.get(j)) % MOD;
      }
    }*/
    return (int) (((sum * sum - sum2) / 2) % MOD);
  }

  private long nc2(long n) {
    return n * (n - 1) / 2;
  }
}
