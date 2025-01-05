package leetcode.contest.weekly.w431_202501;

import java.util.*;

/**
 * @author Vivek
 * @since 2025-01-04
 */
public class Q3412_M_FindMirrorScoreOfAString {
  private static final Map<Character, Character> map = new HashMap<>();

  public static void main(String[] args) {
    Q3412_M_FindMirrorScoreOfAString q3412MFindMirrorScoreOfAString =
        new Q3412_M_FindMirrorScoreOfAString();
    System.out.println(q3412MFindMirrorScoreOfAString.calculateScore("aczzx")); // 5
    System.out.println(q3412MFindMirrorScoreOfAString.calculateScore("abcdef")); // 0
  }

  public long calculateScore(String s) {
    if (map.isEmpty()) { // init 1 time
      for (char ch1 = 'a', ch2 = 'z'; ch1 <= 'z'; ch1++, ch2--) map.put(ch1, ch2);
    }

    long score = 0;
    int n = s.length();
    List<TreeSet<Integer>> sets = new ArrayList<>(26);
    for (int i = 0; i < 26; i++) sets.add(new TreeSet<>());

    for (int i = 0; i < n; i++) {
      int ch = s.charAt(i) - 'a';
      sets.get(ch).add(i);
    }

    for (int i = 1; i < n; i++) {
      char ch = s.charAt(i), inv = map.get(ch);
      int ich = ch - 'a', iinv = inv - 'a';
      Integer j = sets.get(iinv).floor(i - 1);
      if (j == null) continue;
      score += i - j;
      sets.get(ich).remove(i);
      sets.get(iinv).remove(j);
    }

    return score;
  }
}
