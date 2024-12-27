package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-12-26
 */
public class Q1014_M_BestSightseeingPair {

  public static void main(String[] args) {
    Q1014_M_BestSightseeingPair q1014MBestSightseeingPair = new Q1014_M_BestSightseeingPair();
    System.out.println(
        q1014MBestSightseeingPair.maxScoreSightseeingPair(new int[] {8, 1, 5, 2, 6}));
    System.out.println(q1014MBestSightseeingPair.maxScoreSightseeingPair(new int[] {1, 2}));
  }

  public int maxScoreSightseeingPair(int[] values) {
    int maxP1 = values[0], max = 0;
    for (int i = 1; i < values.length; i++) {
      max = Math.max(max, maxP1 + values[i] - i);
      if (values[i] + i > maxP1) {
        maxP1 = values[i] + i;
      }
    }
    return max;
  }
}
