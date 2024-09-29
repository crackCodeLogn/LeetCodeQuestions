package leetcode.contest.weekly.w417_202409;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2024-09-28
 */
public class Q3306_M_CountOfSubstringsContainingEveryVowelAndKConsonantsII_WA {

  private int k;

  public static void main(String[] args) {
    Q3306_M_CountOfSubstringsContainingEveryVowelAndKConsonantsII_WA
        q3306MCountOfSubstringsContainingEveryVowelAndKConsonantsII =
            new Q3306_M_CountOfSubstringsContainingEveryVowelAndKConsonantsII_WA();
    System.out.println(
        q3306MCountOfSubstringsContainingEveryVowelAndKConsonantsII.countOfSubstrings("aeioqq", 1));
    System.out.println(
        q3306MCountOfSubstringsContainingEveryVowelAndKConsonantsII.countOfSubstrings("aeiou", 0));
    System.out.println(
        q3306MCountOfSubstringsContainingEveryVowelAndKConsonantsII.countOfSubstrings(
            "ieaouqqieaouqq", 1));
    System.out.println(
        q3306MCountOfSubstringsContainingEveryVowelAndKConsonantsII.countOfSubstrings(
            "aadieuoh", 1)); // 2
    System.out.println(
        q3306MCountOfSubstringsContainingEveryVowelAndKConsonantsII.countOfSubstrings(
            "eiaaoui", 0)); // 2 - wa
  }

  private boolean compute(int[] counter) {
    return counter[5] == k
        && counter[0] > 0
        && counter[1] > 0
        && counter[2] > 0
        && counter[3] > 0
        && counter[4] > 0;
  }

  private boolean isVowel(char ch) {
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
  }

  public long countOfSubstrings(String word, int k) {
    long cnt = 0;
    this.k = k;
    Map<Character, Integer> map = new HashMap<>();
    map.put('a', 0);
    map.put('e', 1);
    map.put('i', 2);
    map.put('o', 3);
    map.put('u', 4);
    int[] counter = new int[6];
    boolean found = false;
    int i = 0;

    for (int j = i; j <= i + 4 + k && j < word.length(); j++)
      counter[map.getOrDefault(word.charAt(j), 5)]++;
    if (compute(counter)) {
      found = true;
      cnt++;
    }

    i = 0;

    for (int j = i + 4 + k + 1; j < word.length() && i < word.length(); j++) {
      counter[map.getOrDefault(word.charAt(j), 5)]++;
      if (compute(counter)) {
        found = true;
        cnt++;
      }
      boolean vowel = isVowel(word.charAt(j));
      if (found) {
        if (vowel) {

          while (i < j && isVowel(word.charAt(i))) {
            counter[map.getOrDefault(word.charAt(i++), 5)]--;
            if (compute(counter)) {
              cnt++;
            }
          }
        } else { // disorientation
          counter[map.getOrDefault(word.charAt(i++), 5)]--;

          if (compute(counter)) {
            cnt++;
          } else {
            found = false;
            i = j;
            counter = new int[6];
            counter[map.getOrDefault(word.charAt(j), 5)]++;
          }
        }
      }
    }

    for (; i < word.length(); i++) {
      counter[map.getOrDefault(word.charAt(i), 5)]--;
      if (compute(counter)) cnt++;
    }

    return cnt;
  }
}
