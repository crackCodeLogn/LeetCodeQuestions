package leetcode.contest.weekly.w446_202504;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vivek
 * @since 2025-04-19
 */
public class Q3522_M_CalculateScoreAfterPerformingInstructions {

  public static void main(String[] args) {
    Q3522_M_CalculateScoreAfterPerformingInstructions
        q3522MCalculateScoreAfterPerformingInstructions =
            new Q3522_M_CalculateScoreAfterPerformingInstructions();
    System.out.println(
        q3522MCalculateScoreAfterPerformingInstructions.calculateScore(
            new String[] {"jump", "add", "add", "jump", "add", "jump"},
            new int[] {2, 1, 3, 1, -2, -3}));
    System.out.println(
        q3522MCalculateScoreAfterPerformingInstructions.calculateScore(
            new String[] {
              "jump", "add", "add",
            },
            new int[] {3, 1, 1}));
    System.out.println(
        q3522MCalculateScoreAfterPerformingInstructions.calculateScore(
            new String[] {"jump"}, new int[] {0}));
  }

  public long calculateScore(String[] instructions, int[] values) {
    long score = 0;
    int i = 0;
    Set<Integer> visited = new HashSet<>();

    while (i >= 0 && i < instructions.length && !visited.contains(i)) {
      String instruction = instructions[i];
      visited.add(i);
      if ("add".equals(instruction)) {
        score += values[i];
        i++;
      } else {
        i = i + values[i];
      }
    }
    return score;
  }
}
