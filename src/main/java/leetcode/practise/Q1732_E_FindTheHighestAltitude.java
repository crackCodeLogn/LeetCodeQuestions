package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-06-18
 */
public class Q1732_E_FindTheHighestAltitude {
  public static void main(String[] args) {
    Q1732_E_FindTheHighestAltitude q1732EFindTheHighestAltitude =
        new Q1732_E_FindTheHighestAltitude();
    System.out.println(q1732EFindTheHighestAltitude.largestAltitude(new int[] {-5, 1, 5, 0, -7}));
    System.out.println(
        q1732EFindTheHighestAltitude.largestAltitude(new int[] {-4, -3, -2, -1, 4, 3, 2}));
  }

  public int largestAltitude(int[] gain) {
    int max = 0, current = 0;
    for (int v : gain) {
      current += v;
      max = Math.max(max, current);
    }
    return max;
  }
}
