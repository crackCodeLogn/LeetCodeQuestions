package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 9/7/25
 */
public class Q1317_E_ConvertIntegerToTheSumOfTwoNoZeroIntegers {

  public static void main(String[] args) {
    Q1317_E_ConvertIntegerToTheSumOfTwoNoZeroIntegers
        q1317EConvertIntegerToTheSumOfTwoNoZeroIntegers =
            new Q1317_E_ConvertIntegerToTheSumOfTwoNoZeroIntegers();
    System.out.println(
        Arrays.toString(q1317EConvertIntegerToTheSumOfTwoNoZeroIntegers.getNoZeroIntegers(4211)));
    System.out.println(
        Arrays.toString(q1317EConvertIntegerToTheSumOfTwoNoZeroIntegers.getNoZeroIntegers(2218)));
    System.out.println(
        Arrays.toString(q1317EConvertIntegerToTheSumOfTwoNoZeroIntegers.getNoZeroIntegers(5000)));
    System.out.println(
        Arrays.toString(q1317EConvertIntegerToTheSumOfTwoNoZeroIntegers.getNoZeroIntegers(10000)));
    System.out.println(
        Arrays.toString(q1317EConvertIntegerToTheSumOfTwoNoZeroIntegers.getNoZeroIntegers(5610)));
    System.out.println(
        Arrays.toString(q1317EConvertIntegerToTheSumOfTwoNoZeroIntegers.getNoZeroIntegers(1111)));
    System.out.println(
        Arrays.toString(q1317EConvertIntegerToTheSumOfTwoNoZeroIntegers.getNoZeroIntegers(2501)));
    System.out.println(
        Arrays.toString(q1317EConvertIntegerToTheSumOfTwoNoZeroIntegers.getNoZeroIntegers(9999)));
    System.out.println(
        Arrays.toString(q1317EConvertIntegerToTheSumOfTwoNoZeroIntegers.getNoZeroIntegers(2)));
    System.out.println(
        Arrays.toString(q1317EConvertIntegerToTheSumOfTwoNoZeroIntegers.getNoZeroIntegers(11)));
  }

  public int[] getNoZeroIntegers(int n) { // 0ms, beats 100%
    for (int i = 1; i < n; i++) {
      int v = n - i;
      if (isNoZero(i) && isNoZero(v)) return new int[] {i, v};
    }
    return null;
  }

  public int[] getNoZeroIntegers_notGood(int n) {
    if (isNoZero(n - 1)) return new int[] {1, n - 1};

    StringBuilder v1 = new StringBuilder();
    String nn = String.valueOf(n);
    int i = 0;
    if (nn.charAt(0) == '1') i++;
    for (; i < nn.length(); i++) v1.append(nn.charAt(i) == '1' ? '2' : '1');
    int v11 = Integer.parseInt(v1.toString());
    return new int[] {v11, n - v11};
  }

  private boolean isNoZero(int n) {
    while (n > 0) {
      if (n % 10 == 0) return false;
      n /= 10;
    }
    return true;
  }
}
