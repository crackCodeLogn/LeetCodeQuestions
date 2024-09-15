package leetcode.contest.weekly.w414_202409;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-09-07
 */
public class Q3281_M_MaximizeScoreOfNumbersInRanges_INCOMPLETE {

  public static void main(String[] args) {
    Q3281_M_MaximizeScoreOfNumbersInRanges_INCOMPLETE
        q3281MMaximizeScoreOfNumbersInRangesNOTSUBMITTED =
            new Q3281_M_MaximizeScoreOfNumbersInRanges_INCOMPLETE();
    System.out.println(
        q3281MMaximizeScoreOfNumbersInRangesNOTSUBMITTED.maxPossibleScore(new int[] {6, 0, 3}, 2));
    System.out.println(
        q3281MMaximizeScoreOfNumbersInRangesNOTSUBMITTED.maxPossibleScore(
            new int[] {2, 6, 13, 13}, 5));
  }

  public int maxPossibleScore(int[] start, int d) {
    Arrays.sort(start);
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < start.length - 1; i++) {
      int[] data = {
        Math.abs(start[i] - start[i + 1]),
        Math.abs(start[i] - start[i + 1] - d),
        Math.abs(start[i] + d - start[i + 1]),
        Math.abs(start[i] + d - start[i + 1] - d)
      };
      Arrays.sort(data);
      min = Math.min(min, data[0]);
    }

    return min;
  }
}
