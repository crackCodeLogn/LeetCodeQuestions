package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-04-20
 */
public class Q2145_M_CountTheHiddenSequences {

  public static void main(String[] args) {
    Q2145_M_CountTheHiddenSequences q2145MCountTheHiddenSequences =
        new Q2145_M_CountTheHiddenSequences();
    System.out.println(
        q2145MCountTheHiddenSequences.numberOfArrays(
            new int[] {83702, -5216}, -82788, 14602)); // 13689
    System.out.println(
        q2145MCountTheHiddenSequences.numberOfArrays(new int[] {-40}, -46, 53)); // 60
    System.out.println(q2145MCountTheHiddenSequences.numberOfArrays(new int[] {1, -3, 4}, 1, 6));
    System.out.println(
        q2145MCountTheHiddenSequences.numberOfArrays(new int[] {3, -4, 5, 1, -2}, -4, 5));
    System.out.println(q2145MCountTheHiddenSequences.numberOfArrays(new int[] {4, -7, 2}, 3, 6));
  }

  public int numberOfArrays(int[] differences, int lower, int upper) { // 4ms, beats 92.06%
    long min = 0, max = 0, sum = 0;
    for (int i = 0; i < differences.length; i++) {
      sum += differences[i];
      min = Math.min(min, sum);
      max = Math.max(max, sum);
    }
    //int diff = differences.length > 1 ? max - min : Math.abs(max);
    //return Math.max(0, upper - lower + 1 - diff);
    return Math.toIntExact(Math.max(0, upper - lower + 1 - (max - min)));
  }
}
