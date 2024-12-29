package leetcode.contest.weekly.w428_202412;

import com.google.common.collect.Lists;
import java.util.*;

/**
 * @author Vivek
 * @since 2024-12-14
 */
public class Q3387_M_MaximizeAmountAfterTwoDaysOfConversions_WA {

  public static void main(String[] args) {
    Q3387_M_MaximizeAmountAfterTwoDaysOfConversions_WA
        q3387MMaximuzeAmountAfterTwoDaysOfConversionsWA =
            new Q3387_M_MaximizeAmountAfterTwoDaysOfConversions_WA();
    /*    System.out.println(
        q2.maxAmount(
            "EUR",
            Lists.newArrayList(Lists.newArrayList("EUR", "USD"), Lists.newArrayList("USD", "JPY")),
            new double[] {2.0, 3.0},
            Lists.newArrayList(
                Lists.newArrayList("JPY", "USD"),
                Lists.newArrayList("USD", "CHF"),
                Lists.newArrayList("CHF", "EUR")),
            new double[] {4, 5, 6}));

    System.out.println(
        q2.maxAmount(
            "NGN",
            Lists.newArrayList(Collections.singleton(Lists.newArrayList("NGN", "EUR"))),
            new double[] {9},
            Lists.newArrayList(Collections.singleton(Lists.newArrayList("NGN", "EUR"))),
            new double[] {6}));

    System.out.println(
        q2.maxAmount(
            "USD",
            Lists.newArrayList(Collections.singleton(Lists.newArrayList("USD", "EUR"))),
            new double[] {1},
            Lists.newArrayList(Collections.singleton(Lists.newArrayList("EUR", "JPY"))),
            new double[] {10}));

    System.out.println(
        q2.maxAmount(
            "C",
            Lists.newArrayList(Collections.singleton(Lists.newArrayList("C", "OX"))),
            new double[] {1.5},
            Lists.newArrayList(Collections.singleton(Lists.newArrayList("C", "OX"))),
            new double[] {9.4}));*/

    System.out.println(
        q3387MMaximuzeAmountAfterTwoDaysOfConversionsWA.maxAmount(
            "A",
            Lists.newArrayList(Lists.newArrayList("A", "P"), Lists.newArrayList("A", "O")),
            new double[] {7.7, 3.9},
            Lists.newArrayList(Lists.newArrayList("O", "A"), Lists.newArrayList("A", "P")),
            new double[] {7.2, 7.7})); // 28.08000
  }

  public double maxAmount(
      String initialCurrency,
      List<List<String>> pairs1,
      double[] rates1,
      List<List<String>> pairs2,
      double[] rates2) {
    double maxAmount = 1;
    /*Map<String, Integer> day1Map = new HashMap<>();
    Map<Integer, String> d1rm = new HashMap<>();
    Map<String, Integer> day2Map = new HashMap<>();
    Map<Integer, String> d2rm = new HashMap<>();
    double[][] day1 = new double[11][11];
    double[][] day2 = new double[11][11];
    int index = 0;
    int rateIndex = 0;

    for (List<String> pair : pairs1) {
      String src = pair.get(0), dest = pair.get(1);
      if (!day1Map.containsKey(src)) {
        day1Map.put(src, index++);
        d1rm.put(index - 1, src);
      }
      if (!day1Map.containsKey(dest)) {
        day1Map.put(dest, index++);
        d1rm.put(index - 1, dest);
      }
      int srcIndex = day1Map.get(src), destIndex = day1Map.get(dest);
      day1[srcIndex][destIndex] = rates1[rateIndex];
      day1[destIndex][srcIndex] = 1.0 / rates1[rateIndex++];
    }

    index = 0;
    rateIndex = 0;
    for (List<String> pair : pairs2) {
      String src = pair.get(0), dest = pair.get(1);
      if (!day2Map.containsKey(src)) {
        day2Map.put(src, index++);
        d2rm.put(index - 1, src);
      }
      if (!day2Map.containsKey(dest)) {
        day2Map.put(dest, index++);
        d2rm.put(index - 1, dest);
      }
      int srcIndex = day2Map.get(src), destIndex = day2Map.get(dest);
      day2[srcIndex][destIndex] = rates2[rateIndex];
      day2[destIndex][srcIndex] = 1.0 / rates2[rateIndex++];
    }

    if (!day2Map.containsKey(initialCurrency)) return maxAmount;

    Set<Integer> visited = new HashSet<>();
    visited.add(day1Map.get(initialCurrency));
    int row = day1Map.get(initialCurrency);
    while (true) {
      int idx = -1;
      for (int j = 0; j < day1.length; j++) {
        if (!visited.contains(j)) {
          maxAmount *= maxRate;
          idx = j;
          visited.add(j);
        }
      }
      if (idx == -1) break;
      row = idx;
    }

    System.out.println(maxAmount + " " + d1rm.get(row));
    visited.clear();

    row = day2Map.get(d1rm.get(row));
    visited.add(row);
    while (!initialCurrency.equals(d2rm.get(row))) {
      double maxRate = 0;
      int idx = -1;
      for (int j = 0; j < day2.length; j++) {
        if (day2[row][j] > maxRate && !visited.contains(j)) {
          maxRate = day2[row][j];
          maxAmount *= maxRate;
          idx = j;
          visited.add(j);
        }
      }
      if (idx == -1) break;
      row = idx;
    }*/

    return Math.max(1.0, maxAmount);
  }

  private double getMaxVal(int row, int target, double[][] day2) {
    Set<Integer> visited = new HashSet<>();
    double maxVal = 1;
    visited.add(row);
    while (row != target) {}

    return Math.max(1, maxVal);
  }
}
