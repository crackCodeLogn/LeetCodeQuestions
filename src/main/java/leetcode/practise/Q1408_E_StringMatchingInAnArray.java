package leetcode.practise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Vivek
 * @since 2025-01-06
 */
public class Q1408_E_StringMatchingInAnArray {
  public static void main(String[] args) {
    Q1408_E_StringMatchingInAnArray q1408EStringMatchingInAnArray =
        new Q1408_E_StringMatchingInAnArray();
    System.out.println(
        q1408EStringMatchingInAnArray.stringMatching(
            new String[] {"mass", "as", "hero", "superhero"}));
    System.out.println(
        q1408EStringMatchingInAnArray.stringMatching(new String[] {"leetcode", "et", "code"}));
    System.out.println(
        q1408EStringMatchingInAnArray.stringMatching(new String[] {"blue", "green", "bu"}));
    System.out.println(
        q1408EStringMatchingInAnArray.stringMatching(
            new String[] {"leetcoder", "leetcode", "od", "hamlet", "am"}));
  }

  public List<String> stringMatching(String[] words) {
    Set<String> data = new HashSet<>();
    for (int i = 0; i < words.length; i++)
      for (int j = 0; j < words.length; j++)
        if (i != j && words[i].contains(words[j])) data.add(words[j]);
    return new ArrayList<>(data);
  }
}
