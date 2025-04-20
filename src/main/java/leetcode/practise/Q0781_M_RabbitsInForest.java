package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2025-04-19
 */
public class Q0781_M_RabbitsInForest {
  public static void main(String[] args) {
    Q0781_M_RabbitsInForest q0781MRabbitsInForest = new Q0781_M_RabbitsInForest();
    System.out.println(q0781MRabbitsInForest.numRabbits(new int[] {1, 1, 1, 2, 2, 2, 2})); // 10
    System.out.println(
        q0781MRabbitsInForest.numRabbits(new int[] {1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2})); // 14
    System.out.println(q0781MRabbitsInForest.numRabbits(new int[] {1, 1, 1, 2, 2, 2})); // 7
    System.out.println(q0781MRabbitsInForest.numRabbits(new int[] {1, 1, 1, 1, 1, 1, 1})); // 8
    System.out.println(q0781MRabbitsInForest.numRabbits(new int[] {1, 1, 2})); // 5
    System.out.println(q0781MRabbitsInForest.numRabbits(new int[] {1, 1, 1, 2})); // 7
    System.out.println(q0781MRabbitsInForest.numRabbits(new int[] {10, 10, 10})); // 11
    System.out.println(q0781MRabbitsInForest.numRabbits(new int[] {10, 10, 10, 11})); // 23
  }

  public int numRabbits(int[] answers) { // 3ms, beats 82.48%
    int cnt = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int answer : answers) map.compute(answer, (key, val) -> val == null ? 1 : val + 1);
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int key = entry.getKey();
      int count = key + 1;
      int val = entry.getValue();
      cnt += (val / count) * count + (val % count == 0 ? 0 : count);
    }
    return cnt;
  }
}
