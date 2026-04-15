package leetcode.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vivek
 * @since 2026-04-14
 */
public class Q2515_E_ShortestDistanceToTargetStringInACircularArray {
  public static void main(String[] args) {
    Q2515_E_ShortestDistanceToTargetStringInACircularArray
        q2515EShortestDistanceToTargetStringInACircularArray =
            new Q2515_E_ShortestDistanceToTargetStringInACircularArray();
    System.out.println(
        q2515EShortestDistanceToTargetStringInACircularArray.closestTarget(
            new String[] {"hello", "i", "am", "leetcode", "hello"}, "hello", 1));
    System.out.println(
        q2515EShortestDistanceToTargetStringInACircularArray.closestTarget(
            new String[] {"a", "b", "leetcode"}, "leetcode", 0));
    System.out.println(
        q2515EShortestDistanceToTargetStringInACircularArray.closestTarget(
            new String[] {"i", "eat", "leetcode"}, "ate", 0));
  }

  public int closestTarget(String[] words, String target, int startIndex) { // 4ms, beats 1.95%
    Map<String, List<Integer>> wordLocationMap = new HashMap<>();
    for (int i = 0; i < words.length; i++)
      wordLocationMap.compute(words[i], (k, v) -> v == null ? new ArrayList<>() : v).add(i);
    if (!wordLocationMap.containsKey(target)) return -1;
    int min = Integer.MAX_VALUE;
    for (Integer v : wordLocationMap.get(target))
      min =
          Math.min(
              min,
              Math.min(
                  Math.abs((startIndex - v - words.length) % words.length),
                  Math.abs((startIndex - v + words.length) % words.length)));
    return min;
  }
}
