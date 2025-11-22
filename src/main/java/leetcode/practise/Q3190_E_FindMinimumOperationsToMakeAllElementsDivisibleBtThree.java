package leetcode.practise;

public class Q3190_E_FindMinimumOperationsToMakeAllElementsDivisibleBtThree {

  public static void main(String[] args) {
    Q3190_E_FindMinimumOperationsToMakeAllElementsDivisibleBtThree
        q3190EFindMinimumOperationsToMakeAllElementsDivisibleBtThree =
            new Q3190_E_FindMinimumOperationsToMakeAllElementsDivisibleBtThree();
    System.out.println(
        q3190EFindMinimumOperationsToMakeAllElementsDivisibleBtThree.minimumOperations(
            new int[] {1, 2, 3, 4}));
    System.out.println(
        q3190EFindMinimumOperationsToMakeAllElementsDivisibleBtThree.minimumOperations(
            new int[] {3, 6, 9}));
  }

  public int minimumOperations(int[] nums) { // 0ms, beats 100%
    int cnt = 0;
    for (int num : nums) {
      int v = num % 3;
      if (v != 0) cnt += Math.min(3 - v, v);
    }
    return cnt;
  }
}
