package leetcode.practise;

public class Q3512_E_MinimumOperationsToMakeArraySumDivisibleByK {
  public static void main(String[] args) {
    Q3512_E_MinimumOperationsToMakeArraySumDivisibleByK
        q3512EMinimumOperationsToMakeArraySumDivisibleByK =
            new Q3512_E_MinimumOperationsToMakeArraySumDivisibleByK();
    System.out.println(
        q3512EMinimumOperationsToMakeArraySumDivisibleByK.minOperations(new int[] {3, 9, 7}, 5));
    System.out.println(
        q3512EMinimumOperationsToMakeArraySumDivisibleByK.minOperations(new int[] {4, 1, 3}, 4));
    System.out.println(
        q3512EMinimumOperationsToMakeArraySumDivisibleByK.minOperations(new int[] {3, 2}, 6));
  }

  public int minOperations(int[] nums, int k) { // 1ms, beats 92.46%
    int sum = 0, cnt = 0;
    for (int i = 0; i < nums.length; i++) sum += nums[i];
    while (sum % k != 0) {
      sum--;
      cnt++;
    }
    return cnt;
  }
}
