package leetcode.contest.weekly.w449_202505;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vivek
 * @since 2025-05-10
 */
public class Q3545_E_MinimumDeletionsForAtMostKDistinctCharacters {

  public static void main(String[] args) {
    Q3545_E_MinimumDeletionsForAtMostKDistinctCharacters
        q3545EMinimumDeletionsForAtMostKDistinctCharacters =
            new Q3545_E_MinimumDeletionsForAtMostKDistinctCharacters();
    System.out.println(q3545EMinimumDeletionsForAtMostKDistinctCharacters.minDeletion("abc", 2));
    System.out.println(q3545EMinimumDeletionsForAtMostKDistinctCharacters.minDeletion("aabb", 2));
    System.out.println(q3545EMinimumDeletionsForAtMostKDistinctCharacters.minDeletion("yyyzz", 1));
  }

  public int minDeletion(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      map.compute(ch, (k1, v) -> v == null ? 1 : v + 1);
    }
    List<Integer> values = new ArrayList<>(map.values());
    Collections.sort(values);
    int cnt = 0;
    for (int i = 0; i < values.size() - k; i++) cnt += values.get(i);
    return cnt;
  }
}
