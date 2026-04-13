package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-04-12
 */
public class Q1848_E_MinimumDistanceToTheTargetElement {

  public static void main(String[] args) {
    Q1848_E_MinimumDistanceToTheTargetElement q1848EMinimumDistanceToTheTargetElement =
        new Q1848_E_MinimumDistanceToTheTargetElement();
    System.out.println(
        q1848EMinimumDistanceToTheTargetElement.getMinDistance(new int[] {1, 2, 3, 4, 5}, 5, 3));
    System.out.println(q1848EMinimumDistanceToTheTargetElement.getMinDistance(new int[] {1}, 1, 0));
    System.out.println(
        q1848EMinimumDistanceToTheTargetElement.getMinDistance(
            new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 1, 0));
  }

  public int getMinDistance(int[] nums, int target, int start) { // 0ms, beats 100%
    int distance = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++)
      if (nums[i] == target) distance = Math.min(distance, Math.abs(i - start));
    return distance;
  }
}
