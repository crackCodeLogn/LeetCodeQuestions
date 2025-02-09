package leetcode.contest.weekly.w435_202502;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2025-02-01
 */
public class Q3442_E_MaximumDifferenceBetweenEvenAndOddFrequencyI {

  private static boolean isOdd(long a) {
    return (a & 1) == 1;
  }

  private static boolean isEven(long a) {
    return !isOdd(a);
  }

  public static void main(String[] args) {
    Q3442_E_MaximumDifferenceBetweenEvenAndOddFrequencyI
        q3442EMaximumDifferenceBetweenEvenAndOddFrequencyI =
            new Q3442_E_MaximumDifferenceBetweenEvenAndOddFrequencyI();
    System.out.println(
        q3442EMaximumDifferenceBetweenEvenAndOddFrequencyI.maxDifference("aaaaabbc"));
    System.out.println(
        q3442EMaximumDifferenceBetweenEvenAndOddFrequencyI.maxDifference("abcabcab"));
  }

  public int maxDifference(String s) {
    int[] freq = new int[26];
    for (int i = 0; i < s.length(); i++) {
      freq[s.charAt(i) - 'a']++;
    }
    Arrays.sort(freq);
    int v1 = 0;
    for (int i = 0; i < 26; i++) {
      if (freq[i] > 0 && isEven(freq[i])) {
        v1 = freq[i];
        break;
      }
    }
    for (int i = 25; i >= 0; i--) {
      if (isOdd(freq[i])) {
        return freq[i] - v1;
      }
    }
    return -1;
  }
}
