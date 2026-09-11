package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-09-11
 */
public class Q3483_E_Unique3DigitEvenNumbers {
  public int totalNumbers(int[] digits) { // 11 ms, beats 19.47%
    int[] count = new int[10];
    for (int num : digits) count[num]++;

    int cnt = 0;
    for (int i = 100; i <= 999; i += 2) {
      int[] cntt = new int[10];
      int j = i;
      while (j > 0) {
        cntt[j % 10]++;
        j /= 10;
      }
      for (j = 0; j < 10; j++) if (count[j] < cntt[j]) break;
      if (j == 10) cnt++;
    }
    return cnt;
  }

  public static void main(String[] args) {
    Q3483_E_Unique3DigitEvenNumbers q3483EUnique3DigitEvenNumbers =
        new Q3483_E_Unique3DigitEvenNumbers();
    System.out.println(q3483EUnique3DigitEvenNumbers.totalNumbers(new int[] {1, 2, 3, 4}));
    System.out.println(q3483EUnique3DigitEvenNumbers.totalNumbers(new int[] {0, 2, 2}));
    System.out.println(q3483EUnique3DigitEvenNumbers.totalNumbers(new int[] {6, 6, 6}));
    System.out.println(q3483EUnique3DigitEvenNumbers.totalNumbers(new int[] {1, 3, 5}));
  }
}
