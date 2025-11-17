package leetcode.practise;

public class Q1437_E_CheckIfAll1sAreAtLeastLengthKPlacesAway {

  public static void main(String[] args) {
    Q1437_E_CheckIfAll1sAreAtLeastLengthKPlacesAway q1437ECheckIfAll1sAreAtLeastLengthKPlacesAway =
        new Q1437_E_CheckIfAll1sAreAtLeastLengthKPlacesAway();
    System.out.println(
        q1437ECheckIfAll1sAreAtLeastLengthKPlacesAway.kLengthApart(
            new int[] {1, 0, 0, 0, 1, 0, 0, 1}, 2));
    System.out.println(
        q1437ECheckIfAll1sAreAtLeastLengthKPlacesAway.kLengthApart(
            new int[] {1, 0, 0, 1, 0, 1}, 2));
  }

  public boolean kLengthApart(int[] nums, int k) { // 1ms, beats 99.71%
    int last = -1;
    boolean result = true;
    for (int i = 0; i < nums.length; i++)
      if (nums[i] == 1) {
        if (last != -1)
          if (i - last - 1 < k) {
            result = false;
            break;
          }
        last = i;
      }
    return result;
  }
}
