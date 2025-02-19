package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2025-02-18
 */
public class Q1415_M_TheKthLexicographicalStringOfAllHappyStringsOfLengthN {

  private final char[] chars = {'a', 'b', 'c'};
  private final List<List<String>> data = new ArrayList<>();

  public static void main(String[] args) {
    Q1415_M_TheKthLexicographicalStringOfAllHappyStringsOfLengthN
        q1415MTheKthLexicographicalStringOfAllHappyStringsOfLengthN =
            new Q1415_M_TheKthLexicographicalStringOfAllHappyStringsOfLengthN();
    System.out.println(
        q1415MTheKthLexicographicalStringOfAllHappyStringsOfLengthN.getHappyString(1, 3)); // c
    System.out.println(
        q1415MTheKthLexicographicalStringOfAllHappyStringsOfLengthN.getHappyString(1, 4)); //
    System.out.println(
        q1415MTheKthLexicographicalStringOfAllHappyStringsOfLengthN.getHappyString(3, 9)); // cab
  }

  public String getHappyString(int n, int k) { // 96 ms, beats 5.01%
    if (data.isEmpty()) {
      for (int i = 1; i <= 10; i++) {
        data.add(new ArrayList<>());
        compute(i, "", '\0', i - 1);
      }
    }
    if (data.get(n - 1).size() < k) return "";
    return data.get(n - 1).get(k - 1);
  }

  private void compute(int n, String s, int lastChar, int idx) {
    if (n == 0) {
      data.get(idx).add(s);
      return;
    }
    for (char ch : chars) {
      if (ch != lastChar) compute(n - 1, s + ch, ch, idx);
    }
  }
}
