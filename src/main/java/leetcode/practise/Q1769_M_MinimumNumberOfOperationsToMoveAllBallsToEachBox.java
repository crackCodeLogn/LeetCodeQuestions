package leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vivek
 * @since 2025-01-05
 */
public class Q1769_M_MinimumNumberOfOperationsToMoveAllBallsToEachBox {
  public static void main(String[] args) {
    Q1769_M_MinimumNumberOfOperationsToMoveAllBallsToEachBox
        q1769MMinimumNumberOfOperationsToMoveAllBallsToEachBox =
            new Q1769_M_MinimumNumberOfOperationsToMoveAllBallsToEachBox();
    /*System.out.println(
    Arrays.toString(
        q1769MMinimumNumberOfOperationsToMoveAllBallsToEachBox.minOperations(
            "110"))); /// 1,1,3*/
    System.out.println(
        Arrays.toString(
            q1769MMinimumNumberOfOperationsToMoveAllBallsToEachBox.minOperations(
                "001011"))); // 11,8,5,4,3,4
  }

  public int[] minOperations(String boxes) { // 3ms, beats 94.79%
    int n = boxes.length();
    int[] data = new int[n];
    int ones = 0, run = 0, i;
    for (i = 0; i < n; i++) { // left pass
      run += ones;
      data[i] += run;
      if (boxes.charAt(i) == '1') ones++;
    }
    for (i = n - 1, ones = 0, run = 0; i >= 0; i--) { // right pass
      run += ones;
      data[i] += run;
      if (boxes.charAt(i) == '1') ones++;
    }
    return data;
  }

  public int[] minOperations2(String boxes) { // slow. 177ms, beats 6.6%
    int n = boxes.length();
    int[] data = new int[n];
    List<Integer> ones = new ArrayList<>();
    for (int i = 0; i < n; i++) if (boxes.charAt(i) == '1') ones.add(i);
    for (int i = 0; i < n; i++) {
      int cnt = 0;
      for (int oneIdx : ones) cnt += Math.abs(i - oneIdx);
      data[i] = cnt;
    }
    return data;
  }
}
