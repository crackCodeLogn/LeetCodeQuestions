package leetcode.practise;

public class Q3736_E_MinimumMovesToEqualArrayElementsIII {
  public int minMoves(int[] nums) { // 1ms, beats 98.02%
    int max = nums[0];
    for (int i = 0; i < nums.length; i++) {
      int n = nums[i];
      if (n > max) max = n;
    }
    int cnt = 0;
    for (int i = 0; i < nums.length; i++) {
      int n = nums[i];
      cnt += max - n;
    }
    return cnt;
  }

  public static void main(String[] args) {
    Q3736_E_MinimumMovesToEqualArrayElementsIII q3736EMinimumMovesToEqualArrayElementsIII =
        new Q3736_E_MinimumMovesToEqualArrayElementsIII();
    System.out.println(q3736EMinimumMovesToEqualArrayElementsIII.minMoves(new int[] {2, 1, 3}));
    System.out.println(q3736EMinimumMovesToEqualArrayElementsIII.minMoves(new int[] {4, 4, 5}));
  }
}
