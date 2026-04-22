package leetcode.practise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Vivek
 * @since 2026-04-21
 */
public class Q2452_M_WordsWithinTwoEditsOfDictionary {

  public static void main(String[] args) {
    Q2452_M_WordsWithinTwoEditsOfDictionary q2452MWordsWithinTwoEditsOfDictionary =
        new Q2452_M_WordsWithinTwoEditsOfDictionary();
    System.out.println(
        q2452MWordsWithinTwoEditsOfDictionary.twoEditWords(
            new String[] {"word", "note", "ants", "wood"}, new String[] {"wood", "joke", "moat"}));
    System.out.println(
        q2452MWordsWithinTwoEditsOfDictionary.twoEditWords(
            new String[] {"yes"}, new String[] {"not"}));
  }

  public List<String> twoEditWords(String[] queries, String[] dictionary) { // 6ms, beats 72.79%
    Set<String> dict = new HashSet<>();
    for (String diction : dictionary) dict.add(diction);

    List<String> data = new ArrayList<>();
    for (String query : queries) {
      if (dict.contains(query)) data.add(query);
      else {
        boolean match = false;
        for (String target : dictionary) {
          int miss = 0;
          for (int i = 0; i < target.length(); i++)
            if (target.charAt(i) != query.charAt(i)) {
              miss++;
              if (miss == 3) break;
            }
          if (miss <= 2) {
            match = true;
            break;
          }
        }
        if (match) data.add(query);
      }
    }
    return data;
  }
}
