package leetcode.practise;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-09-16
 */
public class Q0884_E_UncommonWordsFromTwoSentences {
  public static void main(String[] args) {
    Q0884_E_UncommonWordsFromTwoSentences q0884EUncommonWordsFromTwoSentences =
        new Q0884_E_UncommonWordsFromTwoSentences();
    System.out.println(
        Arrays.toString(
            q0884EUncommonWordsFromTwoSentences.uncommonFromSentences(
                "this apple is sweet", "this apple is sour")));
    System.out.println(
        Arrays.toString(
            q0884EUncommonWordsFromTwoSentences.uncommonFromSentences("apple apple", "banana")));
  }

  public String[] uncommonFromSentences(String s1, String s2) {
    Map<String, Integer> map1 = new HashMap<>();
    Map<String, Integer> map2 = new HashMap<>();

    for (String s11 : s1.split(" ")) {
      Integer val = map1.getOrDefault(s11, 0);
      map1.put(s11, val + 1);
    }
    for (String s22 : s2.split(" ")) {
      Integer val = map2.getOrDefault(s22, 0);
      map2.put(s22, val + 1);
    }
    List<String> data = new ArrayList<>();
    for (String key : map1.keySet())
      if (map1.get(key) == 1 && !map2.containsKey(key)) data.add(key);
    for (String key : map2.keySet())
      if (map2.get(key) == 1 && !map1.containsKey(key)) data.add(key);

    return data.toArray(new String[0]);
  }
}
